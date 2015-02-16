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
 * @author LabClass
 */
public class SelectCountryValidator implements Validator
{
    public boolean supports(Class clazz)
    {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors)
    {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        System.out.println("--------------------------login validator validate method");

        ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "idCountry", "required.idCountry",
        "Country is required.");
    }
}
