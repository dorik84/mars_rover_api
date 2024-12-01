package ca.odoroshchuk.mars_rover_api.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import ca.odoroshchuk.mars_rover_api.dto.RootDto;
import ca.odoroshchuk.mars_rover_api.response.MarsRoverApiResponse;
import lombok.extern.slf4j.Slf4j;

@Service
public class MarsRoverApiService {
    public MarsRoverApiResponse getRoverData(/*String selectedCamera, Integer sol*/RootDto rootDto){
        Integer sol = rootDto.getSol();
        String selectedCamera = rootDto.getSelectedCamera();
        System.out.println(sol);
        System.out.println(URI.create("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol="+sol+"&camera="+selectedCamera+"&api_key=M0Y3IEXJ1I6iUoZSrghj8EvhgMKy1huhjHLYgsif").toString());
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
        // Not important api_key
                .uri(URI.create("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol="+sol+"&camera="+selectedCamera+"&api_key=M0Y3IEXJ1I6iUoZSrghj8EvhgMKy1huhjHLYgsif"))
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
}
