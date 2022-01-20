package lv.restart.your.love.Final.Project.Restart.Your.Love.validation;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * A custom validator to make sure that the password and matchingPassword fields match up.
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserSignUpDto user = (UserSignUpDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
