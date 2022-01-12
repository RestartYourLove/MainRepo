package lv.restart.your.love.Final.Project.Restart.Your.Love.validation;

import lv.restart.your.love.Final.Project.Restart.Your.Love.dto.UserSignUpDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserSignUpDto user = (UserSignUpDto) obj;
        System.out.println("Debug original password " + user.getPassword() + " matching password " + user.getMatchingPassword());
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
