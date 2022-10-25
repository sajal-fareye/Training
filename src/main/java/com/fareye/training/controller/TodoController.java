package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import com.fareye.training.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/todos")
    public ResponseEntity gettodos(){
        return new ResponseEntity(todoService.gettodos(),HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity gettodo(@PathVariable("id") Integer id){
        return new ResponseEntity<>(this.todoService.getTodo(id),HttpStatus.OK);
    }

    @PostMapping("/todos")
    public ResponseEntity createTodo(@RequestBody Todo todo){
        return new ResponseEntity(todoService.addTodo(todo),HttpStatus.OK);
    }

    @PutMapping("/todos")
    public ResponseEntity updateTodo(@RequestBody Todo todo){
        return new ResponseEntity(todoService.updateTodo(todo),HttpStatus.OK);
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity deleteTodo(@PathVariable("id") Integer id){
        try {
            todoService.deleteTodo(id);
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
