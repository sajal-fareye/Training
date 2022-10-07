package com.fareye.training.model;

import com.fareye.training.service.Password;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class User {

    private int userid;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private boolean verified;
    private boolean created;
    private boolean modified;
    private Password originalPassword;

}
