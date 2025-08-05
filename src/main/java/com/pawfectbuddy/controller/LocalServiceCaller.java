package com.pawfectbuddy.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pawfectbuddy.controller.dto.RegistrationRequest;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
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
    // call API service to register a new user and redirect him to profile if successful
    public void callLocalAPI() {
        ObjectMapper mapper = new ObjectMapper();
        try (HttpClient client = HttpClient.newHttpClient()) {
            String jsonString = mapper.writeValueAsString(registrationRequest);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/api/users/register"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if(response.statusCode() == 200) FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Your account was created successfully!"));
        } catch (Exception e) {
            System.out.println("Error while sending http request to API endpoint: " + e.getMessage());
        }
    }
}