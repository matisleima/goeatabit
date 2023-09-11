package ee.valiit.goeatabit.business.signup;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.contact.ContactService;
import ee.valiit.goeatabit.domain.image.Image;
import ee.valiit.goeatabit.domain.image.ImageService;
import ee.valiit.goeatabit.domain.rating.RatingService;
import ee.valiit.goeatabit.domain.role.Role;
import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Resource
    private RoleService roleService;
    @Resource
    private UserService userService;

    @Resource
    private RatingService ratingService;
    @Resource
    private ImageService imageService;
    @Resource
    private ContactService contactService;
    @Resource
    private LocationService locationService;

    public Integer signUp(SignUpRequest signUpRequest) {
        userService.confirmUserAvailability(signUpRequest.getEmail());

        String roleName = "user";
        Role role = roleService.getRole(roleName);

        User savedUser = userService.saveUser(signUpRequest, role);
        ratingService.saveRating(savedUser);
        Image savedImage = imageService.saveImageData(signUpRequest);
        contactService.saveContact(signUpRequest, savedImage, savedUser);
        locationService.saveLocation(signUpRequest, savedUser);
        return savedUser.getId();
    }
}
