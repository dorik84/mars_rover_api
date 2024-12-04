package ca.odoroshchuk.mars_rover_api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.odoroshchuk.mars_rover_api.dto.UserPreferences;

public interface UserPreferencesRepository extends JpaRepository<UserPreferences,Long>{

    Optional<UserPreferences> findByUserId(Long userId);

    void deleteByUserId(Long userId);

}
