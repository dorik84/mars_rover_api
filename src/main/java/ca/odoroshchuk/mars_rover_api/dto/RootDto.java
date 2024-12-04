package ca.odoroshchuk.mars_rover_api.dto;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
public class RootDto extends UserPreferences {

    private HashMap<String,String> cameras = new HashMap<String,String> ();

    public RootDto(){
        this.populateCameras();
    }


    public RootDto(UserPreferences userPreferences){
        super(
            userPreferences.getUserId(),
            userPreferences.getSelectedCamera(),
            userPreferences.getSol(),
            userPreferences.getRememberMe()
        );
        this.populateCameras();
    }

    public UserPreferences getUserPreferences(){
        return new UserPreferences(this.getUserId(), this.getSelectedCamera(), this.getSol(), this.getRememberMe());
    }

    private void populateCameras(){
        this.cameras.put("FHAZ","Front Hazard Avoidance Camera");
        this.cameras.put("RHAZ","Rear Hazard Avoidance Camera");
        this.cameras.put("MAST","Mast Camera");
        this.cameras.put("CHEMCAM","Chemistry and Camera Complex");
        this.cameras.put("MAHLI","Mars Hand Lens Imager");
        this.cameras.put("MARDI","Mars Descent Imager");
        this.cameras.put("NAVCAM","Navigation Camera");
    }
}
