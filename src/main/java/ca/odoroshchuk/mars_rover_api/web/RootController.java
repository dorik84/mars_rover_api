package ca.odoroshchuk.mars_rover_api.web;

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
    public String getHomeView(ModelMap model, @RequestParam(defaultValue = "curiosity" ) String roverName, @RequestParam(defaultValue = "curiosity" ) String radioCkeckedId) {
        System.out.println(roverName);
        MarsRoverApiResponse roverData = roverApiService.getRoverData(roverName);
        model.put("roverData",roverData);
        model.put("radioCkeckedId",radioCkeckedId);
        System.out.println(roverData.toString());
        return "index";
    }

    // @PostMapping("/")
    // public String getRoverDataByName(ModelMap model, @RequestParam String roverName) {
    //     MarsRoverApiResponse roverData = roverApiService.getRoverData(roverName);
    //     model.put("roverData",roverData);
    //     return "index";
  
    // }
    
    

}
