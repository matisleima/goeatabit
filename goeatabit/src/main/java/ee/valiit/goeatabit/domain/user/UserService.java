package ee.valiit.goeatabit.domain.user;


import ee.valiit.goeatabit.validation.ValidationService;
import ee.valiit.goeatabit.validation.Status;
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


    public void confirmUserAvailability(String email) {
        boolean userEmailExists = userRepository.userExistsBy(email);
        ValidationService.validateEmailIsAvailable(userEmailExists);
    }

    public User getUserBy(Integer userId) {
        return userRepository.getReferenceById(userId);

    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
