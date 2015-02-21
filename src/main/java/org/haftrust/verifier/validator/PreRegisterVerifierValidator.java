/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.PreRegisterVerifierBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Miroslav
 */
public class PreRegisterVerifierValidator implements Validator {

    private VerifierService verifierService;

    public VerifierService getVerifierService() {
        return verifierService;
    }

    public void setVerifierService(VerifierService verifierService) {
        this.verifierService = verifierService;
    }

    public boolean supports(Class clazz) {
        return clazz.equals(PreRegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors) {
        PreRegisterVerifierBean prvBean = (PreRegisterVerifierBean) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "email", "required.email",
                "Email is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "password", "required.password",
                "Password is required.");

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "repassword", "required.repassword",
                "Re-Password is required.");

        if (prvBean.getEmail().length() > 45) {
            errors.rejectValue("email", "required.email", "Email is required to be up to 45 characters long.");
        }

        if (prvBean.getEmail().length() < 6) {
            errors.rejectValue("email", "required.email", "Email is required to be at least 6 characters long.");
        }

        if (!prvBean.getEmail().contains("@")) {
            errors.rejectValue("email", "required.email", "Valid email is required '@'.");
        }

        if (!prvBean.getEmail().contains(".")) {
            errors.rejectValue("email", "required.email", "Valid email is required '.'.");
        }

        boolean b = this.verifierService.checkEmail(prvBean.getEmail());

        if (b) {
            errors.rejectValue("email", "required.email", "Email already in use.");
        }

        if (prvBean.getPassword().length() > 20) {
            errors.rejectValue("password", "required.password", "Password is required to be up to 20 characters long.");
        }

        if (prvBean.getPassword().length() < 6) {
            errors.rejectValue("password", "required.password", "Password is required to be at least 6 characters long.");
        }

        char c[] = prvBean.getPassword().toCharArray();
        boolean intB = false;

        CHARS: for (int i = 0; i < c.length; i++) {
            if (Character.isDigit(c[i]) == true) {
                intB = true;
                break CHARS;
            }
        }

        if (!intB) {
            errors.rejectValue("password", "required.password", "Password is required to contain at least one digit.");
        }

        if (!prvBean.getRepassword().equals(prvBean.getPassword())) {
            errors.rejectValue("repassword", "required.repassword", "Re-Password is required to match Password.");
        }

    }
}
