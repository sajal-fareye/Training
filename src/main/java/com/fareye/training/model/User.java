package com.fareye.training.model;

import com.fareye.training.resttemplate.RestTemplateProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String githubUserName;
    private boolean verified;
    private boolean created;
    private boolean modified;
    private Password userPassword;
    private String gitAvatar;

    public void setGithubUserName(String githubUserName) throws JsonProcessingException {
        this.githubUserName = githubUserName;
        this.gitAvatar = RestTemplateProvider.getavtar(githubUserName);
    }

    public User(){
        created=true;
    }

}
