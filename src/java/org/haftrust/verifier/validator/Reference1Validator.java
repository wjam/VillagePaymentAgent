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
public class Reference1Validator implements Validator
{
    public boolean supports(Class clazz)
    {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors)
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1FullName", "required.reference1FullName",
        "Full Name is required.");

        if (rvBean.getReference1FullName().length() > 45)
        {
            errors.rejectValue("reference1FullName", "required.reference1FullName", "Full Name is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1OrganisationName", "required.reference1OrganisationName",
        "Organisation Name is required.");

        if (rvBean.getReference1OrganisationName().length() > 45)
        {
            errors.rejectValue("reference1OrganisationName", "required.reference1OrganisationName", "Organisation Name is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1Designation", "required.reference1Designation",
        "Designation is required.");

        if (rvBean.getReference1Designation().length() > 45)
        {
            errors.rejectValue("reference1Designation", "required.reference1Designation", "Designation is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1ContactNumber", "required.reference1ContactNumber",
        "Contact Number is required.");

        if (rvBean.getReference1ContactNumber().length() > 25)
        {
            errors.rejectValue("reference1ContactNumber", "required.reference1ContactNumber", "Contact Number is required to be up to 25 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1Email", "required.reference1Email",
        "Email is required.");

        if (rvBean.getReference1Email().length() > 45)
        {
            errors.rejectValue("reference1Email", "required.reference1Email", "Email is required to be up to 45 characters long.");
        }

        if (rvBean.getReference1Email().length() < 6)
        {
            errors.rejectValue("reference1Email", "required.reference1Email", "Email is required to be at least 6 characters long.");
        }

        if (!rvBean.getReference1Email().contains("@"))
        {
            errors.rejectValue("reference1Email", "required.reference1Email", "Valid email is required '@'.");
        }

        if (!rvBean.getReference1Email().contains("."))
        {
            errors.rejectValue("reference1Email", "required.reference1Email", "Valid email is required '.'.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "reference1Address", "required.reference1Address",
        "Address is required.");

        if (rvBean.getReference1Address().length() > 100)
        {
            errors.rejectValue("reference1Address", "required.reference1Address", "Address is required to be up to 100 characters long.");
        }
    }
}
