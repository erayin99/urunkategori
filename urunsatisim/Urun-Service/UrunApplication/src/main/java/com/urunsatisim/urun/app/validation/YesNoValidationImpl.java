package com.urunsatisim.urun.app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YesNoValidationImpl implements ConstraintValidator<YesNoValidation, String> {


    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
       // "(E|H)$"
        Pattern pattern = Pattern.compile ( "(E|H)$" );
        Matcher matcher = pattern.matcher (s);
        return matcher.find ();


    }
}
