/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.RegisterVerifierBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Miroslav
 */
public class Reference2Validator implements Validator {

    public boolean supports(Class clazz) {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors) {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2FullName", "required.reference2FullName",
                "Full Name is required.");

        if (rvBean.getReference2FullName().length() > 45) {
            errors.rejectValue("reference2FullName", "required.reference2FullName", "Full Name is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2OrganisationName", "required.reference2OrganisationName",
                "Organisation Name is required.");

        if (rvBean.getReference2OrganisationName().length() > 45) {
            errors.rejectValue("reference2OrganisationName", "required.reference2OrganisationName", "Organisation Name is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2Designation", "required.reference2Designation",
                "Designation is required.");

        if (rvBean.getReference2Designation().length() > 45) {
            errors.rejectValue("reference2Designation", "required.reference2Designation", "Designation is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2ContactNumber", "required.reference2ContactNumber",
                "Contact Number is required.");

        if (rvBean.getReference2ContactNumber().length() > 25) {
            errors.rejectValue("reference2ContactNumber", "required.reference2ContactNumber", "Contact Number is required to be up to 25 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2Email", "required.reference2Email",
                "Email is required.");

        if (rvBean.getReference2Email().length() > 45) {
            errors.rejectValue("reference2Email", "required.reference2Email", "Email is required to be up to 45 characters long.");
        }

        if (rvBean.getReference2Email().length() < 6) {
            errors.rejectValue("reference2Email", "required.reference2Email", "Email is required to be at least 6 characters long.");
        }

        if (!rvBean.getReference2Email().contains("@")) {
            errors.rejectValue("reference2Email", "required.reference2Email", "Valid email is required '@'.");
        }

        if (!rvBean.getReference2Email().contains(".")) {
            errors.rejectValue("reference2Email", "required.reference2Email", "Valid email is required '.'.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "reference2Address", "required.reference2Address",
                "Address is required.");

        if (rvBean.getReference1Address().length() > 100) {
            errors.rejectValue("reference2Address", "required.reference2Address", "Address is required to be up to 100 characters long.");
        }
    }
}
