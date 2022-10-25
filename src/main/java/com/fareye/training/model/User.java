package com.fareye.training.model;

import com.fareye.training.resttemplate.RestTemplateProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String firstname;
    private String lastname;
    private String email;
//    private String role;
//    private String githubUserName;
//    private boolean verified;
//    private boolean created;
//    private boolean modified;
//    private Password userPassword;
//    private String gitAvatar;
//
//    public void setGithubUserName(String githubUserName) throws JsonProcessingException {
//        this.githubUserName = githubUserName;
//        this.gitAvatar = RestTemplateProvider.getavtar(githubUserName);
//    }

//    public User(){
//        created=true;
//    }

    public User(String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
//        created=true;
    }
}
