package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@SpringBootApplication
public class TemplateApplication {

	public static void main(String[] args) {
		String resourcePath = "/templates/tvsAgreementFormTemplate.vm"; // Adjust the path
		String base64String = convertFileToBase64(resourcePath);
		System.out.println("Base64 String: " + base64String);
	}

	public static String convertFileToBase64(String resourcePath) {
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