package com.fareye.training.helper;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;


public class TodoValidator implements ConstraintValidator<TodoValidation, String> {

    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!list.contains(s)) {
            list.add(s);
            return true;
        }
        return false;
    }

    List<String> list = new ArrayList<String>();
}
