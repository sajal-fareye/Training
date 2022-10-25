package com.fareye.training.service;

import com.fareye.training.dao.UserDao;
import com.fareye.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> getUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public User addUser(User user) {
        userDao.save(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        userDao.save(user);
        return  user;
    }

    @Override
    public void deleteUser(Integer id) {
        User temp = userDao.findById(id).get();
        userDao.delete(temp);
    }
}
