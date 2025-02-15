package Ejercicios.source.Clase9.GananciaDeCompra.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import com.google.gson.*;

public class StockMaxProfit {
    private static final String API_KEY = "KYALRYI3VSGKRVTZ";
    private static final String API_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=" + API_KEY;

    public static String getStockData(String symbol) throws Exception {
        String urlString = String.format(API_URL, symbol);
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static TreeMap<String, Double> parseStockData(String jsonResponse) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");

        TreeMap<String, Double> stockPrices = new TreeMap<>();
        for (Map.Entry<String, ?> entry : timeSeries.entrySet()) {
            JsonObject dailyData = (JsonObject) entry.getValue();
            double closePrice = dailyData.get("4. close").getAsDouble();
            stockPrices.put(entry.getKey(), closePrice);
        }
        return stockPrices;
    }

    public static int maxProfit(int K, double[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[K + 1][n];
        for (int k = 1; k <= K; k++) {
            int maxDiff = - (int) prices[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], (int) prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - (int) prices[i]);
            }
        }
        return dp[K][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el símbolo de la acción (ejemplo: IBM): ");
        String symbol = scanner.nextLine();
        System.out.print("Ingrese el número máximo de transacciones (K): ");
        int K = scanner.nextInt();

        try {
            String jsonResponse = getStockData(symbol);
            TreeMap<String, Double> stockPrices = parseStockData(jsonResponse);
            double[] prices = stockPrices.values().stream().mapToDouble(Double::doubleValue).toArray();
            System.out.println("Máxima ganancia posible: " + maxProfit(K, prices));
        } catch (Exception e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
        }
    }
}
