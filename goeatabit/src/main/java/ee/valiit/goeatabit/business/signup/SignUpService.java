package ee.valiit.goeatabit.business.signup;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
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

    public void signUp(SignUpRequest signUpRequest) {
        userService.confirmUserAvailability(signUpRequest.getEmail());

        //pane default kasutaja roleId muutujasse
        String roleName = "user";
        Role role = roleService.getRole(roleName);


        //salvesta roleId ning email ja password DTOst USER tabelisse

        User savedUser = userService.saveUser(signUpRequest, role);

        //salvesta userId RATING tabelisse
        ratingService.saveRating(savedUser);

        //salvesta imageData IMAGE tabelisse
        imageService.saveImageData(signUpRequest);

        //salvesta imageId CONTACT tabelisse
        contactService.saveImageId(signUpRequest);

        //salvesta districtId ja userId LOCATION tabelisse
        locationService.saveDistrictIdAndUserId(signUpRequest);

        //tagasta userId fronti
    }
}
