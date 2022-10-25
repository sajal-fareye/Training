package com.fareye.training.service;

import com.fareye.training.dao.TodoDao;
import com.fareye.training.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return todoDao.findById(id).get();
    }

    @Override
    public Todo addTodo(Todo todo) {
        todoDao.save(todo);
        return todo;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        todoDao.save(todo);
        return todo;
    }

    @Override
    public void deleteTodo(Integer id) {
        todoDao.deleteById(id);
    }
}
