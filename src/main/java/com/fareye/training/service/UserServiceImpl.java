package com.fareye.training.service;

import com.fareye.training.dao.UserDao;
import com.fareye.training.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        userDao.findById(user.getUserid()).orElseThrow(()-> new NoSuchElementException("This ID = "+user.getUserid()+" is not here"));
        userDao.save(user);
        return  user;
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.findById(id).get();
        userDao.deleteById(id);
    }
}
