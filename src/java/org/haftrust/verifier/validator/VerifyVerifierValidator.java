/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.VerifyVerifierBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Miroslav
 */
public class VerifyVerifierValidator implements Validator
{
    public boolean supports(Class clazz)
    {
        return clazz.equals(VerifyVerifierBean.class);
    }

    public void validate(Object command, Errors errors)
    {
        VerifyVerifierBean vvBean = (VerifyVerifierBean) command;

        /*ValidationUtils.rejectIfEmptyOrWhitespace(
        errors, "verifierVerificationComment", "required.verifierVerificationComment",
        "Verification Comment is required.");*/
    }
}
