package ca.odoroshchuk.mars_rover_api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
public class MarsRoverApiResponse {
    @Getter
    @Setter
    List<MarsPhoto> photos;
}
