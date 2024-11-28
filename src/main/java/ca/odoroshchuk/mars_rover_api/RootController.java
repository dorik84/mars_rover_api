package ca.odoroshchuk.mars_rover_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RootController {

    @GetMapping("/")
    public String getHomeView(ModelMap model) {
        model.put("name", "Oleksandr");
        return "index";
    }
    

}
