package com.springapp.mvc;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;

import java.io.InputStream;
import java.net.MalformedURLException;

public abstract class UserInputSanitizer {

    private static Policy policy;
    private static AntiSamy antiSamy;

    private static AntiSamy getAntiSamy() throws PolicyException, MalformedURLException {
        if (antiSamy == null) {
            policy = getPolicy();
            antiSamy = new AntiSamy();
        }
        return antiSamy;

    }

    public static String sanitize(String input) {
        CleanResults cr;
        try {
            cr = getAntiSamy().scan(input, policy);
        } catch (Exception e) {
            System.out.println("error policy");
            throw new RuntimeException(e);
        }
        return cr.getCleanHTML();
    }

    private static Policy getPolicy() throws PolicyException, MalformedURLException {

        InputStream inputStream =
                UserInputSanitizer.class.getClassLoader().getResourceAsStream("antisamy/antisamy.xml");

        Policy policy = Policy.getInstance(inputStream);

        return policy;
    }
}
