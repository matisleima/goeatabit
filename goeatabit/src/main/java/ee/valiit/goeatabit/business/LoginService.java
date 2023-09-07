package ee.valiit.goeatabit.business;

import ee.valiit.goeatabit.LoginResponse;
import ee.valiit.goeatabit.User;
import ee.valiit.goeatabit.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;



    public LoginResponse login(String email, String password) {
        User user = userService.findActiveUserBy(email, password);
        return userMapper.toLoginResponse(user);
    }
}
