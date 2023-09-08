package ee.valiit.goeatabit.business.signup;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.role.Role;
import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserRepository;
import ee.valiit.goeatabit.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    @Resource
    private RoleService roleService;

    @Resource
    private UserService userService;
    private final UserRepository userRepository;

    public SignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(SignUpRequest signUpRequest) {
        //pane default kasutaja roleId muutujasse
        String roleName = "user";
        Role roleId = roleService.getRoleId(roleName);

        //salvesta roleId ning email ja password DTOst USER tabelisse
        User user =
        userService.saveCredentialsAndRoleId(user);

        //salvesta userId RATING tabelisse
        //salvesta imageData IMAGE tabelisse
        //salvesta imageId CONTACT tabelisse
        //salvesta districtId ja userId LOCATION tabelisse
        //tagasta userId fronti
    }
}
