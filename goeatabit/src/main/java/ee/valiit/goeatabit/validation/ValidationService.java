package ee.valiit.goeatabit.validation;

import ee.valiit.goeatabit.domain.user.User;
import ee.valiit.goeatabit.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ee.valiit.goeatabit.util.Error.INCORRECT_CREDENTIALS;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }
}