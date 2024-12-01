package ca.odoroshchuk.mars_rover_api.dto;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class RootDto {
   
    private String selectedCamera;
    private Integer sol;
    private HashMap<String,String> cameras = new HashMap<String,String> ();

    public RootDto(){
        this.selectedCamera = "FHAZ";
        this.sol = 1000;
        this.cameras.put("FHAZ","Front Hazard Avoidance Camera");
        this.cameras.put("RHAZ","Rear Hazard Avoidance Camera");
        this.cameras.put("MAST","Mast Camera");
        this.cameras.put("CHEMCAM","Chemistry and Camera Complex");
        this.cameras.put("MAHLI","Mars Hand Lens Imager");
        this.cameras.put("MARDI","Mars Descent Imager");
        this.cameras.put("NAVCAM","Navigation Camera");
    }
}
