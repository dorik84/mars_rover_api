package ca.odoroshchuk.mars_rover_api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MarsCamera {
    private Long id;
    private String name;
    @JsonProperty("rover_id")
    private Long roverId;
    @JsonProperty("full_name")
    private String fullName;
}
