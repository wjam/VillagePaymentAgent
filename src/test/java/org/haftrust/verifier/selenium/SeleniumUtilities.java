package org.haftrust.verifier.selenium;

import com.google.common.io.ByteStreams;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;

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

    public static String photo() throws IOException {
        return getPhotoResource().getFile().getAbsolutePath();
    }

    public static byte[] photoAsBytes() throws IOException {
        return ByteStreams.toByteArray(getPhotoResource().getInputStream());
    }

    private static Resource getPhotoResource() {
        return new DefaultResourceLoader().getResource("/120px-PNG_transparency_demonstration_1.png");
    }
}
