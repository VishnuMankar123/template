package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

public class Testing {

    private static ObjectMapper mapper = new ObjectMapper();
    public static void main(String[] args) throws IOException {
        System.out.println("hello world");
        // Create a JSON object representing the given data
        String json ="{\"statusCode\":\"SR\",\"oLocation\":{\"lat\":12.930717,\"lng\":80.111879},\"sApproximateAddress\":\"Chennai,TamilNadu600045,India\",\"sError\":null,\"sStatusMessage\":null,\"location_type\":\"APPROXIMATE\",\"types\":\"postal_code\",\"data\":{\"location_type\":\"APPROXIMATE\",\"types\":\"postal_code\",\"gaddress\":null,\"lang\":null,\"lat\":null}}";  // Convert the JSON object to a String
     jsonToString(json);
    }

    public static void jsonToString(String json) throws IOException {
        // Create a Gson instance

        Gson gson = new Gson();

        // Parse the JSON string into a Java object (assuming it's a valid JSON)
        GeoTaggingTvsResponse jsonObject =StringToObject (json, GeoTaggingTvsResponse.class);

        System.out.println(jsonObject.toString());



    }
    public static <T> T StringToObject(String jsonString, Class<?> type) throws IOException {
        return (T)mapper.readValue(jsonString, type);

    }


}
