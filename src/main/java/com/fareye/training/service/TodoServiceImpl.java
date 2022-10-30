package com.fareye.training.service;

import com.fareye.training.dao.TodoDao;
import com.fareye.training.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoDao todoDao;
    @Override
    public List<Todo> gettodos() {
        return todoDao.findAll();
    }

    @Override
    public Todo getTodo(Integer id) {
        return todoDao.findById(id).orElseThrow(()->new NoSuchElementException("this id= "+id+" is not here"));
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoDao.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        todoDao.findById(todo.getTodoid()).orElseThrow(()->new NoSuchElementException("this id= "+todo.getTodoid()+" is not here"));
        todoDao.save(todo);
        return todo;
    }

    @Override
    public void deleteTodo(Integer id) {
        todoDao.findById(id).orElseThrow(()->new NoSuchElementException("this id= "+id+" is not here"));
        todoDao.deleteById(id);
    }
}
