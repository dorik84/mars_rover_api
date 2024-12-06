package ca.odoroshchuk.mars_rover_api.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.odoroshchuk.mars_rover_api.config.ApiKeyProvider;
import ca.odoroshchuk.mars_rover_api.dto.UserPreferences;
import ca.odoroshchuk.mars_rover_api.repository.UserPreferencesRepository;
import ca.odoroshchuk.mars_rover_api.response.MarsRoverApiResponse;
import jakarta.transaction.Transactional;


@Service
public class MarsRoverApiService {
    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Autowired
    private ApiKeyProvider apiKeyProvider;

    @Cacheable(value = "apiCache", key = "#userPreferences")
    public MarsRoverApiResponse getRoverData(UserPreferences userPreferences){
        System.out.println("getRoverData triggered");
        Integer sol = userPreferences.getSol();
        String selectedCamera = userPreferences.getSelectedCamera();
        
        String apiKey = apiKeyProvider.getApiKey();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        // Not important api_key
                .uri(URI.create("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol="+sol+"&camera="+selectedCamera+"&api_key="+apiKey))
                .GET()
                .build();

        HttpResponse<String> response;
        MarsRoverApiResponse body = new MarsRoverApiResponse();
        ObjectMapper mapper = new ObjectMapper(); 

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            body =  mapper.readValue(response.body(), MarsRoverApiResponse.class);

        } catch (IOException | InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        return body;
    }



    public UserPreferences save(UserPreferences userPreferences) {
        UserPreferences savedPreferences = userPreferencesRepository.save(userPreferences);
        return savedPreferences;
    }



    public UserPreferences findPreferencesByUserId(Long userId) {
        UserPreferences rootDto = userPreferencesRepository.findByUserId(userId).orElse(new UserPreferences());
        return rootDto;
    }


    @Transactional
    public void delete(UserPreferences userPreferences) {
        userPreferencesRepository.deleteByUserId(userPreferences.getUserId());
    }

  
}