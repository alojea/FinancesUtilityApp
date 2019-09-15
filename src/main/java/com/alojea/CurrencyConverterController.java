package com.alojea;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Map;

import com.alojea.model.RateValues;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CurrencyConverterController{

    static final int MODULE = 26;
    static final String API_KEY = "8B2JEOZB8P2BD6OO"; 
    
    public RateValues getCurrencyRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
    
    	HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .uri(URI.create("https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency="
            				+ fromCurrency +"&to_currency="
            				+ toCurrency + "&apikey=" + API_KEY))
            .build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String responseBody = response.body();
        int responseStatusCode = response.statusCode();

        System.out.println("httpGetRequest: " + responseBody);
        System.out.println("httpGetRequest status code: " + responseStatusCode);
    	
        
        return JsonTransformation(response.body());
    }
    
    private RateValues JsonTransformation(String responseJsonObj) {
    	Type dataType = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
    	Gson gson = new Gson();
    	
    	Map<String, Map<String, String>> data = gson.fromJson(responseJsonObj, dataType);
    	
    	
    	
    	return parseJsonValues(data.values().stream().findFirst().orElse(Collections.emptyMap()));
    }
    
    private RateValues parseJsonValues(Map<String, String> data) {
    	
    	RateValues rateValues = new RateValues(data.get("1. From_Currency Code"),
    										   data.get("2. From_Currency Name"),
    										   data.get("3. To_Currency Code"),
    										   data.get("4. To_Currency Name"),
    										   Float.valueOf(data.get("5. Exchange Rate")),
    										   LocalDateTime.parse(data.get("6. Last Refreshed"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
    										   data.get("7. Time Zone"),
    										   Float.valueOf(data.get("8. Bid Price")),
    										   Float.valueOf(data.get("9. Ask Price")));
    	
    	return rateValues;
    }
    
    public Float calculateRate(Float amount, RateValues rateValues) {
    	return amount * rateValues.getExchangeRate();
    }
    
}
