package ee.valiit.goeatabit.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Resource
    private LoginService loginService;


    public void login(@RequestParam String email, @RequestParam String password) {
        loginService.login(email, password);
    }

}
