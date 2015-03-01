package org.haftrust.verifier.selenium;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphanumeric;

public final class SeleniumUtilities {

    private SeleniumUtilities() {
        super();
    }

    public static String password() {
        return "1a" + randomAlphanumeric(18);
    }

    public static String email() {
        return randomAlphanumeric(20) + "@" + randomAlphanumeric(20) + ".com";
    }
}
