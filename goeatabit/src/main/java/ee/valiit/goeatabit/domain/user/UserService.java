package ee.valiit.goeatabit.domain.user;


import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import ee.valiit.goeatabit.domain.role.Role;
import ee.valiit.goeatabit.validation.ValidationService;
import ee.valiit.goeatabit.util.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private UserMapper userMapper;

    public User findActiveUserBy(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }

    public User saveUser(SignUpRequest signUpRequest, Role role) {
        //tee eraldi meetod setAndSaveUser
        User user = userMapper.toUser(signUpRequest);
        user.setRole(role);
        user.setStatus(Status.ACTIVE.getLetter());
        User savedUser = userRepository.save(user);//pane see salvestusakt ka muutujasse. save-meetod tagastab muuhulgas ühe User klassi objekti!!
        return savedUser;

        //Integer id = userRepository.save(user).getId();
    }
}
