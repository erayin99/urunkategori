package com.urunsatisim.urun.app.validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint( validatedBy = YesNoValidationImpl.class)
public  @interface YesNoValidation {

    String messgae() default "E, H olabilir";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
