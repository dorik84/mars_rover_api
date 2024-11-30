package ca.odoroshchuk.mars_rover_api.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import ca.odoroshchuk.mars_rover_api.response.MarsRoverApiResponse;
import ca.odoroshchuk.mars_rover_api.service.MarsRoverApiService;
import ch.qos.logback.core.util.StringUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class RootController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(ModelMap model, @RequestParam(defaultValue = "FHAZ" ) String selectedCamera) {
        System.out.println(selectedCamera);
        MarsRoverApiResponse roverData = roverApiService.getRoverData(selectedCamera);

        List<String> cameras = Arrays.asList("FHAZ", "RHAZ", "MAST", "CHEMCAM", "MAHLI", "MARDI", "NAVCAM");
        model.put("roverData",roverData);
        model.put("selectedCamera",selectedCamera);
        model.put("cameras",cameras);
        System.out.println("selectedCamera: "+selectedCamera);
  
        return "index";
    }
    
    

}
