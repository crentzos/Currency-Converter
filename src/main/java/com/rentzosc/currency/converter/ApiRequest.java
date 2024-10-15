package com.rentzosc.currency.converter;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiRequest {
    private static final String ACCESS_KEY = "12e43d4641327706356da449e371330c";
    private static final String API_URI = "http://api.exchangeratesapi.io/v1/latest";

    public String getLatestExchangeRates() throws IOException, InterruptedException {
        String url = String.format("%s?access_key=%s&format=1", API_URI, ACCESS_KEY);

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            return httpResponse.body();
        } catch(Exception ex) {
            ex.printStackTrace();
            return  "An error occured while making the request to API";
        }
    }
}
