package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@RestController
public class TodoController {

    HashMap<Integer,Todo> todos = new HashMap<Integer, Todo>();
    int todoID;

    @GetMapping("/todo")
    public HashMap<Integer,Todo> gettodos(){
        return todos;
    }

    @PostMapping("/createtodo")
    public HashMap<Integer,Todo> createTodo(@RequestBody Todo todo){
        todo.setTodoid(todoID);
        todos.put(todoID,todo);
        todoID++;
        return todos;
    }

    @PutMapping("/todo/{id}")
    public Todo updateTodo(@RequestBody Todo todo,@PathVariable("id") int id) throws Exception{
        if(!todos.containsKey(id)) throw new Exception("This id is not here");
        todo.setTodoid(id);
        todos.put(id,todo);
       return todos.get(id);
    }

    @DeleteMapping("/todo/{id}")
    public HashMap<Integer,Todo> deleteTodo(@PathVariable("id") int id) throws Exception{
        if(!todos.containsKey(id)) throw new Exception("This id is not here");
        todos.remove(id);
        return todos;
    }
}
