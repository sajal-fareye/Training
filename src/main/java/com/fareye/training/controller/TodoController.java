package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Optional;

@RestController
public class TodoController {

    HashMap<Integer,Todo> todos = new HashMap<Integer, Todo>();
    int todoID;

    @GetMapping("/todos")
    public HashMap<Integer,Todo> gettodos(){
        return todos;
    }

    @GetMapping("/todos/{id}")
    public Todo  gettodo(@PathVariable("id") int id) throws Exception {
        if(!todos.containsKey(id)) throw new Exception("This id is not here");
        return todos.get(id);
    }

    @PostMapping("/todos")
    public Todo createTodo(@Valid @RequestBody Todo todo){
        todo.setTodoId(todoID);
        todos.put(todoID,todo);
        todoID++;
        return todos.get(todoID-1);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@RequestBody Todo todo,@PathVariable("id") int id) throws Exception{
        if(!todos.containsKey(id)) throw new Exception("This id is not here");
        todo.setTodoId(id);
        todos.put(id,todo);
       return todos.get(id);
    }

    @DeleteMapping("/todos/{id}")
    public HashMap<Integer,Todo> deleteTodo(@PathVariable("id") int id) throws Exception{
        if(!todos.containsKey(id)) throw new Exception("This id is not here");
        todos.remove(id);
        return todos;
    }
}
