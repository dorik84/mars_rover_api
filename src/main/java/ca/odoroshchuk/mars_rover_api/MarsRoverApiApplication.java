package ca.odoroshchuk.mars_rover_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MarsRoverApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApiApplication.class, args);
	}

}
