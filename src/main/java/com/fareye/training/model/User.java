package com.fareye.training.model;

import com.fareye.training.resttemplate.RestTemplateProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userid;
    private String firstname;
    private String lastname;
    private String email;

    private String password;
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

    private String role;

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(this.role);
//        authorities.add(authority);
//        return  authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return this.passowrd;
//    }
//
//    @Override
//    public String getUsername() {
//        return this.firstname;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
