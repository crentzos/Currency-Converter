package com.rentzosc.currency.converter;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParseJson {
    public static Map<String , Double> extractRates(String jsonBody) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            Map<String, Object> bodyMap = mapper.readValue(jsonBody, new TypeReference<Map<String, Object>>() {});
            if (bodyMap.containsKey("rates")) {
                Map<String , Number> ratesMap = (Map<String , Number>) bodyMap.get("rates");
                Map<String, Double> rates = new HashMap<>();
                for (Map.Entry<String, Number> entry : ratesMap.entrySet()) {
                    rates.put(entry.getKey(), entry.getValue().doubleValue());
                }
                return rates;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("An error occurred while extracting rates");
        }
        return Collections.emptyMap();
    }
}
