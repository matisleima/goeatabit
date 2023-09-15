package ee.valiit.goeatabit.domain.location;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {


    @Resource
    private LocationRepository locationRepository;

    public void saveLocation(Location location) {
        locationRepository.save(location);
    }

    public Location getLocationBy(Integer userId) {
        return locationRepository.getLocationBy(userId);
    }

}
