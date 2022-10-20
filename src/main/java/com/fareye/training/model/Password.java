package com.fareye.training.model;

import com.fareye.training.util.Encryption;

public class Password {

    private String securedPassword;
    private String saltValue;

    public void generatePassword(String originalPassword) {
        this.saltValue = Encryption.getSaltvalue(30);
        this.securedPassword = Encryption.generateSecurePassword(originalPassword, saltValue);
    }

    public Password(String originalPassword) {
        this.saltValue = Encryption.getSaltvalue(30);
        this.securedPassword = Encryption.generateSecurePassword(originalPassword, saltValue);
    }
    public boolean checkPassword(String providedPassword) {
        return Encryption.verifyUserPassword(providedPassword, securedPassword, saltValue);
    }
}
