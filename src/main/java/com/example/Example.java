package com.example;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Base64;
import java.io.InputStream;
import java.net.InetSocketAddress;

public class Example {



    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/download", new DownloadHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }

    static class DownloadHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            // Read the Base64 data (you can replace this with your logic to fetch the data)
            String base64Data = getBase64Data();

            // Set the Content-Type header
            exchange.getResponseHeaders().set("Content-Type", "application/octet-stream");

            // Set other headers if needed, e.g., Content-Disposition for file name
            exchange.getResponseHeaders().set("Content-Disposition", "attachment; filename=file.bin");

            // Send the Base64 data as the response body
            exchange.sendResponseHeaders(200, base64Data.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(Base64.getDecoder().decode(base64Data));
            }
        }
    }

    // Replace this with your logic to get the Base64 data
    private static String getBase64Data() {
        String resourcePath = "/templates/tvsAgreementFormTemplate.vm"; // Adjust the path
        try {
            InputStream inputStream = TemplateApplication.class.getResourceAsStream(resourcePath);
            if (inputStream != null) {
                byte[] fileBytes = inputStream.readAllBytes();
                return Base64.getEncoder().encodeToString(fileBytes);
            } else {
                System.err.println("Resource not found: " + resourcePath);
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}



