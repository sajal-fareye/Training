package com.fareye.training.service;

import com.fareye.training.util.Encryption;

public class Password {

    private String originalPassword;
    private String securedPassword;
    private String saltValue;

    public void generatePassword(String originalPassword){

        this.originalPassword = originalPassword;
        this.saltValue = Encryption.getSaltvalue(30);
        this.securedPassword= Encryption.generateSecurePassword(originalPassword, this.saltValue);
    }

    public void checkPassword(String saltValue){

    }

    public String getSecuredPassword() {
        return securedPassword;
    }
}
