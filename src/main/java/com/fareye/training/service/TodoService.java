
package com.fareye.training.service;

import com.fareye.training.model.Todo;

import java.util.List;

public interface TodoService {


    public List<Todo> gettodos();

    public Todo getTodo(Integer id);

    public Todo addTodo(Todo todo);

    public Todo updateTodo(Todo todo);

    public void deleteTodo(Integer id);
}

