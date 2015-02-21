/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import org.haftrust.verifier.view.RegisterVerifierBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author LabClass
 */
public class SelectCountryValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger(SelectCountryValidator.class);

    public boolean supports(Class clazz) {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors) {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        LOG.debug("--------------------------login validator validate method");

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "idCountry", "required.idCountry",
                "Country is required.");
    }
}
