package ca.odoroshchuk.mars_rover_api.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user_preferences")
@Data
public class UserPreferences {
   
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long userId;

    @Column(length=20)
    private String selectedCamera;

    private Integer sol;
    private Boolean rememberMe;

    public UserPreferences(){
        this.rememberMe = false;
        this.selectedCamera = "FHAZ";
        this.sol = 1000;
    }

    public UserPreferences(Long userId, String selectedCamera, Integer sol, Boolean rememberMe) {
        this.userId=userId;
        this.rememberMe = rememberMe;
        this.selectedCamera = selectedCamera;
        this.sol = sol;
    }
}
