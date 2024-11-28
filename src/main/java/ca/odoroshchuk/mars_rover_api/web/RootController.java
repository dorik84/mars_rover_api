package ca.odoroshchuk.mars_rover_api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import ca.odoroshchuk.mars_rover_api.response.MarsRoverApiResponse;
import ca.odoroshchuk.mars_rover_api.service.MarsRoverApiService;



@Controller
public class RootController {

    @Autowired
    private MarsRoverApiService roverApiService;

    @GetMapping("/")
    public String getHomeView(ModelMap model) {
        MarsRoverApiResponse roverData = roverApiService.getRoverData();
        model.put("roverData",roverData);
        return "index";
    }
    

}
