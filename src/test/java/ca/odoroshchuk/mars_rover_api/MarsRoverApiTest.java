package ca.odoroshchuk.mars_rover_api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MarsRoverApiTest {
    
    @Test
    public void smallTest(){
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()

                .uri(URI.create("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=2&api_key=M0Y3IEXJ1I6iUoZSrghj8EvhgMKy1huhjHLYgsif"))
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            ObjectMapper mapper = new ObjectMapper(); 
            MarsRoverApiResponse res = mapper.readValue(response.body(), MarsRoverApiResponse.class);
            System.out.println(response.statusCode());
            System.out.println(res.getPhotos().get(0).getRover().getCameras());
        } catch (IOException | InterruptedException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}
