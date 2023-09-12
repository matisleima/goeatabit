package ee.valiit.goeatabit.domain.location;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.user.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Resource
    private LocationMapper locationMapper;

    @Resource
    private LocationRepository locationRepository;

    public void saveLocation(SignUpRequest signUpRequest, User savedUser) {
        Location location = locationMapper.toLocation(signUpRequest);
        location.setUser(savedUser);
        locationRepository.save(location);
    }

    public Location getLocationBy(Integer userId) {
        return locationRepository.getLocationBy(userId);
    }
}
