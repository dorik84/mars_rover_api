package ca.odoroshchuk.mars_rover_api;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MarsRover {
    private Long id;
    private String name;
    private Date landing_date;
    private Date launch_date;
    private String status;
    private Integer max_sol;
    private Date max_date;
    private Integer total_photos;
    List<MarsCamera> cameras;
 
}
