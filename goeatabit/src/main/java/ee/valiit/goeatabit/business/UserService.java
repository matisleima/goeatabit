package ee.valiit.goeatabit.business;


import ee.valiit.goeatabit.User;
import ee.valiit.goeatabit.UserRepository;
import ee.valiit.goeatabit.domain.ValidationService;
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
