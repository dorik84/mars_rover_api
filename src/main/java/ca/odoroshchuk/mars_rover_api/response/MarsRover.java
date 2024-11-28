package ca.odoroshchuk.mars_rover_api.response;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MarsRover {
    private Long id;
    private String name;

    @JsonProperty("landing_date")
    private LocalDate landingDate;
    
    @JsonProperty("launch_date")
    private LocalDate launchDate;

    private String status;

    @JsonProperty("max_sol")
    private Integer maxSol;

    @JsonProperty("max_date")
    private LocalDate maxDate;


    @JsonProperty("total_photos")
    private Integer totalPhotos;
    List<MarsCamera> cameras;
 
    private LocalDate parseStringToDate(String strData){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Parse the date string to LocalDate 
        return LocalDate.parse(strData, formatter); // Convert LocalDate to LocalDateTime at the start of the day 
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = this.parseStringToDate(launchDate);
    }

    public void setLandingDate(String landingDate) {
        this.landingDate = this.parseStringToDate(landingDate);
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = this.parseStringToDate(maxDate);
    }

}
