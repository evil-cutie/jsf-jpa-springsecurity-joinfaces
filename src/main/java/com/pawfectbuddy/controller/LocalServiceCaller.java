package com.pawfectbuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawfectbuddy.controller.dto.RegistrationRequest;
import jakarta.enterprise.context.RequestScoped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component(value="serviceCaller")
@RequestScoped
public class LocalServiceCaller {
    RegistrationRequest registrationRequest = new RegistrationRequest();
    public void callLocalAPI() {
        HttpResponse<String> response;
        ObjectMapper mapper = new ObjectMapper();
        try (HttpClient client = HttpClient.newHttpClient()) {
            String jsonString = mapper.writeValueAsString(registrationRequest);
            System.out.println(jsonString);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/users/register"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Response Status Code: " + response.statusCode());
            System.out.println("Response headers: " + response.headers());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            System.out.println("Error while sending http request to API: " + e.getMessage());
        }
    }
}