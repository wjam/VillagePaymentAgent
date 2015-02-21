/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import java.util.ArrayList;
import java.util.List;
import org.haftrust.verifier.model.Bank;
import org.haftrust.verifier.service.VerifierService;
import org.haftrust.verifier.view.RegisterVerifierBean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Miroslav
 */
public class BankValidator implements Validator {

    private VerifierService verifierService;

    public VerifierService getVerifierService() {
        return verifierService;
    }

    public void setVerifierService(VerifierService verifierService) {
        this.verifierService = verifierService;
    }

    public boolean supports(Class clazz) {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors) {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "bankAccountNumber", "required.bankAccountNumber",
                "Account Number is required.");

        if (!rvBean.getBankAccountNumber().equals("")) {
            boolean b = true;

            for (int i = 0; i < rvBean.getBankAccountNumber().length(); i++) {
                if (Character.isDigit(rvBean.getBankAccountNumber().charAt(i)) == false) {
                    b = false;
                }
            }

            if (b == false) {
                errors.rejectValue("bankAccountNumber",
                        "required.bankAccountNumber", "Account Number is required in numeric format. ");
            }

            List<Bank> bankList = new ArrayList<Bank>();

            try {
                bankList = this.verifierService.isBankAccountRegistered(rvBean.getBankAccountNumber());

                if (bankList.size() > 0) {
                    errors.rejectValue("bankAccountNumber",
                            "required.bankAccountNumber", "Account Number already registered.");
                }
            } catch (Exception e) {
                System.out.println("--------- bank validator, is bank account registered exception");
            }

            if (rvBean.getBankAccountNumber().length() < 7) {
                errors.rejectValue("bankAccountNumber",
                        "required.bankAccountNumber", "Account Number cannot be less than 7 digits.");
            }

            if (rvBean.getBankAccountNumber().length() > 10) {
                errors.rejectValue("bankAccountNumber",
                        "required.bankAccountNumber", "Account Number exceeds the maximum value of 10 digits.");
            }

            if (rvBean.getBankAccountNumber().equals("0")) {
                errors.rejectValue("bankAccountNumber",
                        "required.bankAccountNumber", "Account Number cannot be 0.");
            }

        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "bankName", "required.bankName",
                "Bank Name is required.");

        if (rvBean.getBankName().length() > 45) {
            errors.rejectValue("bankName", "required.bankName", "Bank Name is required to be up to 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "bankContactNumber", "required.bankContactNumber",
                "Telephone is required.");

        if (rvBean.getBankContactNumber().length() > 25) {
            errors.rejectValue("bankContactNumber", "required.bankContactNumber", "Telephone is required to be up to 25 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "bankAddress", "required.bankAddress",
                "Bank Address is required.");

        if (rvBean.getBankAddress().length() > 100) {
            errors.rejectValue("bankAddress", "required.bankAddress", "Bank Address is required to be up to 100 characters long.");
        }

        if (!rvBean.getBankSortCode().equals("")) {
            if (rvBean.getBankSortCode().length() > 6) {
                errors.rejectValue("bankSortCode", "required.bankSortCode", "Sort Code is required to be up to 6 numbers long.");
            }

            if (rvBean.getBankSortCode().length() < 6) {
                errors.rejectValue("bankSortCode", "required.bankSortCode", "Sort Code is required to be up to 6 numbers long.");
            }

            try {
                boolean b = true;

                for (int i = 0; i < rvBean.getBankSortCode().length(); i++) {
                    if (Character.isDigit(rvBean.getBankSortCode().charAt(i)) == false) {
                        b = false;
                    }
                }

                if (b == false) {
                    errors.rejectValue("bankSortCode",
                            "required.bankSortCode", "Sortcode is required in numeric format.");
                }

            } catch (NumberFormatException nfe) {
                errors.rejectValue("bankSortCode",
                        "required.bankSortCode", "Sortcode is required in numeric format.");

            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "bankIban", "required.bankIban",
                "Bank IBAN is required.");

        if (!rvBean.getBankIban().equals("")) {
            if (rvBean.getBankIban().length() > 35) {
                errors.rejectValue("bankIban", "required.bankIban", "Bank IBAN is required to be up to 35 characters long.");
            }

            if (rvBean.getBankIban().length() < 15) {
                errors.rejectValue("bankIban", "required.bankIban", "Bank IBAN is required to be minimum 15 characters long.");
            }
        }
    }
}
