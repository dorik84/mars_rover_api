package ca.odoroshchuk.mars_rover_api;

import java.util.Date;

import lombok.Data;

@Data
public class MarsPhoto {
    private Long id;
    private Integer sol;
    private MarsCamera camera;
    private String img_src;
    private Date earth_date;
    private MarsRover rover;
}
