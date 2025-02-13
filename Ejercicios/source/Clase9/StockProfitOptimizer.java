package Ejercicios.source.Clase9;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import com.google.gson.*;

public class StockProfitOptimizer {
    private static final String API_KEY = "FTVZQOSR5NEEP48N";
    private static final String BASE_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=%s&apikey=%s";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el símbolo de la acción (ej. IBM, AAPL): ");
        String symbol = scanner.nextLine();
        
        List<Double> prices = obtenerPrecios(symbol);
        if (prices.isEmpty()) {
            System.out.println("No se pudieron obtener los datos de la acción.");
            return;
        }
        
        int K = 2;  // Número máximo de transacciones
        double maxProfit = calcularMaxGanancia(prices, K);
        System.out.println("Ganancia máxima posible con " + K + " transacciones: " + maxProfit);
    }

    private static List<Double> obtenerPrecios(String symbol) {
        List<Double> precios = new ArrayList<>();
        try {
            String urlString = String.format(BASE_URL, symbol, API_KEY);
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();
            JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (Daily)");

            TreeMap<String, Double> sortedPrices = new TreeMap<>(Collections.reverseOrder());
            for (String date : timeSeries.keySet()) {
                double price = timeSeries.getAsJsonObject(date).get("4. close").getAsDouble();
                sortedPrices.put(date, price);
            }

            precios.addAll(sortedPrices.values());
        } catch (Exception e) {
            System.out.println("Error al obtener datos: " + e.getMessage());
        }
        return precios;
    }

    private static double calcularMaxGanancia(List<Double> precios, int K) {
        int n = precios.size();
        if (n == 0) return 0;

        double[][] dp = new double[K + 1][n];

        for (int k = 1; k <= K; k++) {
            double maxDiff = -precios.get(0);
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], precios.get(i) + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - precios.get(i));
            }
        }
        return dp[K][n - 1];
    }
}
