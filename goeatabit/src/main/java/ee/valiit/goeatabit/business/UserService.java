package ee.valiit.goeatabit.business;


import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.domain.user.UserRepository;
import ee.valiit.goeatabit.validation.ValidationService;
import ee.valiit.goeatabit.util.Status;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    public User findActiveUserBy(String email, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(email, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }
}
