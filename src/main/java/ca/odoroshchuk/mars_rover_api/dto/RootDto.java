package ca.odoroshchuk.mars_rover_api.dto;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;

import lombok.Data;

@Data
public class RootDto {
   
    private String selectedCamera;
    private Integer sol;
    private HashMap<String,String> cameras = new HashMap<String,String> ();
    private Boolean rememberMe;
    private UUID userUID;

    public RootDto(){
        this.userUID = UUID.randomUUID();
        this.rememberMe = false;
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
