package ca.odoroshchuk.mars_rover_api.web;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.odoroshchuk.mars_rover_api.dto.RootDto;
import ca.odoroshchuk.mars_rover_api.dto.UserPreferences;
import ca.odoroshchuk.mars_rover_api.repository.UserPreferencesRepository;
import ca.odoroshchuk.mars_rover_api.response.MarsRoverApiResponse;
import ca.odoroshchuk.mars_rover_api.service.MarsRoverApiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;





@Controller
@SessionAttributes("userPreferences")
public class RootController {

    @Autowired
    private MarsRoverApiService roverApiService;

    // @ModelAttribute("userId")
    // public Long userId() {
    //     return null; 
    // }
    @ModelAttribute("userPreferences") 
    public UserPreferences userPreferences() { 
        return new UserPreferences(); // Initialize with default values or null 
    }

    @GetMapping("/")
    public String getHomeView(Model model, @ModelAttribute("rootDto") RootDto rootDto,  @ModelAttribute("userPreferences") UserPreferences userPreferences) {
        // userPreferences = new UserPreferences();
        System.out.println("------GetMapping");
        System.out.println(rootDto);
        
        // System.out.println(userId);
        if (Boolean.TRUE.equals(userPreferences.getRememberMe())){
            rootDto = new RootDto(userPreferences);
        //     Long userId = userPreferences.getUserId();
        //     userPreferences = roverApiService.findPreferencesByUserId(userId);
        } else {
            userPreferences = rootDto.getUserPreferences();
        }
        // System.out.println(userPreferences);
        
        
        MarsRoverApiResponse roverData = roverApiService.getRoverData(userPreferences);
        // System.out.println(rootDto);
        model.addAttribute("roverData", roverData);
        model.addAttribute("rootDto", rootDto);

        return "index";
    }

    @PostMapping("/")
    public String postMethodName(Model model, @ModelAttribute("rootDto") RootDto rootDto, SessionStatus sessionStatus, RedirectAttributes redirectAttributes) {
        System.out.println("------PostMapping");
        UserPreferences userPreferences = rootDto.getUserPreferences();
        
        System.out.println(userPreferences);
        if (Boolean.TRUE.equals(userPreferences.getRememberMe())){
            System.out.println("userPreferences saved in session");
            userPreferences = roverApiService.save(userPreferences);
            model.addAttribute("userPreferences", userPreferences);
        } else {
            System.out.println("session cleared");
            sessionStatus.setComplete();
            // roverApiService.delete(userPreferences);
        }
        // System.out.println(userPreferences);
        
        // System.out.println("savedPreferences");
        System.out.println(userPreferences);
        // RootDto rootDto = new RootDto(savedPreferences);
        // System.out.println(rootDto.getUserId() );
        // model.addAttribute("rootDto", rootDto);
        redirectAttributes.addFlashAttribute("rootDto",rootDto);

        
        // model.addAttribute("userId", userPreferences.getUserId());
        return "redirect:/";
    }
}
