package Ejercicios.source.Clase9;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.*;

public class StockTrading {
    private static final String API_KEY = "FTVZQOSR5NEEP48N";
    private static final String SYMBOL = "IBM";

    public static void main(String[] args) throws IOException {
        List<Double> prices = fetchStockPrices();
        if (prices.isEmpty()) {
            System.out.println("No se pudieron obtener precios.");
            return;
        }
        int K = 2; // Número máximo de transacciones
        double maxProfit = maxProfit(K, prices);
        System.out.println("Ganancia máxima con " + K + " transacciones: " + maxProfit);
    }

    public static List<Double> fetchStockPrices() throws IOException {
        String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + SYMBOL + "&apikey=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();
        return parseJson(response.toString());
    }

    public static List<Double> parseJson(String jsonResponse) {
        List<Double> prices = new ArrayList<>();
        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonObject timeSeries = jsonObject.getAsJsonObject("Time Series (Daily)");
        TreeMap<String, Double> sortedPrices = new TreeMap<>(Collections.reverseOrder());
        for (String date : timeSeries.keySet()) {
            double closePrice = timeSeries.getAsJsonObject(date).get("4. close").getAsDouble();
            sortedPrices.put(date, closePrice);
        }
        prices.addAll(sortedPrices.values());
        return prices;
    }

    public static double maxProfit(int K, List<Double> prices) {
        int n = prices.size();
        if (n == 0) return 0;
        double[][] dp = new double[K + 1][n];
        for (int k = 1; k <= K; k++) {
            double maxDiff = -prices.get(0);
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices.get(i) + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices.get(i));
            }
        }
        return dp[K][n - 1];
    }
}
