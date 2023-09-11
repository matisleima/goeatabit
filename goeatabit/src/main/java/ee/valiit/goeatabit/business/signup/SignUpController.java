package ee.valiit.goeatabit.business.signup;

import ee.valiit.goeatabit.business.signup.dto.SignUpRequest;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Resource SignUpService signUpService;

    @PostMapping("/sign-up")
    public Integer signUp(@RequestParam SignUpRequest signUpRequest) {

        return signUpService.signUp(signUpRequest);
    }
}
