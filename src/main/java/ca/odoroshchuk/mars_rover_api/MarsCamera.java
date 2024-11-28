package ca.odoroshchuk.mars_rover_api;

import lombok.Data;

@Data
public class MarsCamera {
    private Long id;
    private String name;
    private Long rover_id;
    private String full_name;
}
