package com.mlg.acciones.service;

import org.owasp.validator.html.AntiSamy;
import org.owasp.validator.html.CleanResults;
import org.owasp.validator.html.Policy;
import org.owasp.validator.html.PolicyException;

/**
 *
 * @author saaperezru
 */
public final class SecurityHelper {

    private Policy policy;
    private AntiSamy antiSamy;
    private static SecurityHelper instance;

    private SecurityHelper(String policyFile) {
        try {
            policy = Policy.getInstance(getClass().getResourceAsStream(policyFile));
            antiSamy = new AntiSamy(policy);
        } catch (PolicyException ex) {
            throw new ExternalServiceException("The specified ANTISAMY policy file for the SecuirtyHelper cannot be accessed");
        }
    }

    private static SecurityHelper getInstance() {
        while (instance == null) {
            //instance = new SecurityHelper(ConfigurationVariablesHelper.getVariable(ConfigurationVariablesHelper.ANTISAMY_POLICY_FILE));
        }
        return instance;
    }

    public static String sanitizeHTML(String input) {
        if (input == null) {
            throw new IllegalArgumentException("The input to sanitize cannot be null");
        }

        try {
            CleanResults cr = getInstance().getAntiSamy().scan(input, getInstance().getPolicy());
            input = cr.getCleanHTML();
        } catch (Exception ex) {
            //Config.getInstance().getServiceFactory().getLogService().error(ex.getMessage(), ex);
            throw new ExternalServiceException("There was a problem while sanitizing", ex);
        }
        return input;
    }

//    public static String hashPassword(String password) {
//        String hash = null;
//        try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256");
//            md.update(password.getBytes(Charset.forName("UTF-8")));
//
//            byte[] mdbytes = md.digest();
//
//            //convert the byte to hex format method 1
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < mdbytes.length; i++) {
//                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//            hash = sb.toString();
//        } catch (NoSuchAlgorithmException ex) {
//            ///Es casi imposible que pase esto
//            Config.getInstance().getServiceFactory().getLogService().error(ex.getMessage(), ex);
//        }
//        return hash;
//    }

    public AntiSamy getAntiSamy() {
        return antiSamy;
    }

    public void setAntiSamy(AntiSamy antiSamy) {
        this.antiSamy = antiSamy;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }
}
