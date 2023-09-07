package ee.valiit.goeatabit.business;

import ee.valiit.goeatabit.User;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;



    public void login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
    }
}
