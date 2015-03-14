/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.haftrust.verifier.view.RegisterVerifierBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Miroslav
 */
public class VerifierValidator implements Validator {

    private static final Logger LOG = LoggerFactory.getLogger(VerifierValidator.class);

    public boolean supports(Class clazz) {
        return clazz.equals(RegisterVerifierBean.class);
    }

    public void validate(Object command, Errors errors) {
        RegisterVerifierBean rvBean = (RegisterVerifierBean) command;

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "firstName", "required.firstName",
                "First Name is required.");

        if (rvBean.getFirstName().length() > 45) {
            errors.rejectValue("firstName", "required.firstName", "First Name is required to be maximum 45 characters long.");
        }

        if (rvBean.getMiddleName().length() > 45) {
            errors.rejectValue("middleName", "required.middleName", "Middle Name is required to be maximum 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "lastName", "required.lastName",
                "Last Name is required.");

        if (rvBean.getLastName().length() > 45) {
            errors.rejectValue("lastName", "required.lastName", "Last Name is required to be maximum 45 characters long.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "telephoneNumber", "required.telephoneNumber",
                "Telephone Number is required.");

        if (rvBean.getTelephoneNumber().length() > 25) {
            errors.rejectValue("telephoneNumber", "required.telephoneNumber", "Telephone Number is required to be maximum 25 characters long.");
        }

        boolean dobOK = true;
        Calendar cal = Calendar.getInstance();
        int year = 0;
        int month = 0;
        int day = 0;
        String[] strSplit = rvBean.getDob().split("-");

        try {
            day = Integer.parseInt(strSplit[0]);
            month = Integer.parseInt(strSplit[1]);
            year = Integer.parseInt(strSplit[2]);
        } catch (NumberFormatException exc) {
            //errors.rejectValue("dob", "required.dob", "Date of Birth is invalid.");
        }

        cal.set(year, month - 1, day);
        java.util.Date today = cal.getTime();
        SimpleDateFormat dateFmt = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = java.sql.Date.valueOf(dateFmt.format(today));
        LOG.debug("------------------------sql date validator = " + sqlDate);
        GregorianCalendar gc = new GregorianCalendar();
        try {
            dobOK = true;

            gc.setLenient(false);        // must do this
            gc.set(GregorianCalendar.YEAR, year);
            gc.set(GregorianCalendar.MONTH, month - 1);// invalid month
            gc.set(GregorianCalendar.DATE, day);

            gc.getTime(); // exception thrown here
        } catch (Exception e) {
            dobOK = false;
            errors.rejectValue("dob", "required.dob", "Date of Birth is invalid.");
            e.printStackTrace();
        }

        if (dobOK) {
            try {

                GregorianCalendar currentDate = new GregorianCalendar();

                java.util.Date d = currentDate.getTime();
                d.setYear(d.getYear() - 23);

                currentDate.setTime(d);

                if (currentDate.before(gc)) {
                    errors.rejectValue("dob", "required.dob", "The Verifier has to be over 23 years old.");
                }
            } catch (Exception exception) {
                LOG.warn("Have to older than 23 years old.", exception);
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "postcode", "required.postcode",
                "Postcode is required.");

        if (rvBean.getPostcode().length() > 10) {
            errors.rejectValue("postcode", "required.postcode", "Postcode is required to be maximum 10 characters long.");
        }

        LOG.debug("-------------------- verifier validator rv bean image: " + rvBean.getImage());

        if (rvBean.getImage() == null) {
            if (rvBean.getFile().isEmpty()) {
                errors.rejectValue("file", "rvBean.file", "Photo is required.");
            } else
                try {
                    if (rvBean.getFile().getInputStream().read() == -1) {
                        errors.rejectValue("file", "rvBean.file", "Photo is required to be greather than 0KB.");
                    }
                } catch (IOException ex) {
                    LOG.error("describeme", ex);
                }

            if (!rvBean.getFile().getContentType().startsWith("image")) {
                errors.rejectValue("file", "rvBean.file", "Photo is required to be an image type.");
            }

            if (rvBean.getFile().getSize() > 100000) {
                errors.rejectValue("file", "rvBean.file", "Photo's size is required to be less than 100kb.");
            }

            LOG.debug("==================================================== file name; {}", rvBean.getFile().getOriginalFilename());
            LOG.debug("====================================================");
        } else {
            LOG.debug("-------------------- verifier validator else rv bean image: {}", rvBean.getImage());

            if (rvBean.getImage().getPhoto().length < 1) {
                if (rvBean.getFile().isEmpty()) {
                    errors.rejectValue("file", "rvBean.file", "Photo is required.");
                } else
                    try {
                        if (rvBean.getFile().getInputStream().read() == -1) {
                            errors.rejectValue("file", "rvBean.file", "Photo is required to be greather than 0KB.");
                        }
                    } catch (IOException ex) {
                        LOG.error("describeme", ex);
                    }

                if (!rvBean.getFile().getContentType().startsWith("image")) {
                    errors.rejectValue("file", "rvBean.file", "Photo is required to be an image type.");
                }

                if (rvBean.getFile().getSize() > 100000) {
                    errors.rejectValue("file", "rvBean.file", "Photo's size is required to be less than 100kb.");
                }

                LOG.debug("==================================================== file name; {}", rvBean.getFile().getOriginalFilename());
                LOG.debug("====================================================");
            }
        }
    }
}
