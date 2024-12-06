package ca.odoroshchuk.mars_rover_api.response;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
public class MarsRoverApiResponse {
    @Getter

    List<MarsPhoto> photos;

    public void setPhotos(List<MarsPhoto> photos) {
        this.photos = photos.stream().limit(10).collect(Collectors.toList());
    }
}
