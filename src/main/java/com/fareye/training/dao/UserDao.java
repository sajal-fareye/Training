package com.fareye.training.dao;

import com.fareye.training.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {
        Optional<User> findByFirstname(String firstname);
}
