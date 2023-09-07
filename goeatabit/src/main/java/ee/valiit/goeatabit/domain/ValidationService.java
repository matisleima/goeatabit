package ee.valiit.goeatabit.domain;

import ee.valiit.goeatabit.User;

import java.util.Optional;

import static ee.valiit.goeatabit.business.Error.INCORRECT_CREDENTIALS;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}
