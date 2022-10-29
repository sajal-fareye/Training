package com.fareye.training.controller;

import com.fareye.training.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TodoControllerTest {

    RestTemplate restTemplate= new RestTemplate();

    @Test
    void getAllTodos(){

//        ResponseEntity res = restTemplate.get("http://localhost:8082/todos")
//        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8082/todos", HttpMethod.GET, requestEntity,String.class);

        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/todos", String.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
    @Test
    void getSingleTodo(){
        int id = 3;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Todo> request = new HttpEntity<Todo>(headers);
        try {
            ResponseEntity<Todo> res = restTemplate.exchange("http://localhost:8082/todos/" + id, HttpMethod.GET, request, Todo.class);
            assertEquals(res.getStatusCode(), HttpStatus.OK);
        }catch (Exception e){
            assertEquals("400 : \"Wrong ID\"",e.getMessage());
        }
    }

    @Test
    void postMappingTodo(){
        Todo todo= new Todo();
        todo.setTodoid(3);
        todo.setTitle("TestController  Post");
        todo.setBody("This Post is from test Controller");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Todo> request = new HttpEntity<Todo>(todo,headers);
        ResponseEntity<Todo> res = restTemplate.exchange("http://localhost:8082/todos",HttpMethod.POST,request, Todo.class);
        assertEquals(res.getStatusCode(), HttpStatus.CREATED);
    }

    @Test
    void putMappingTodo(){
        Todo todo= new Todo();
        todo.setTodoid(3);
        todo.setTitle("TestController  Put");
        todo.setBody("This Put is from test Controller");
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Todo> request = new HttpEntity<Todo>(todo,headers);
        ResponseEntity<Todo> res = restTemplate.exchange("http://localhost:8082/todos",HttpMethod.PUT,request, Todo.class);
        assertEquals(res.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void deleteTodoMap(){
        int id=3;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> request = new HttpEntity<String>(headers);
        try {
            ResponseEntity res = restTemplate.exchange("http://localhost:8082/todos/"+id,HttpMethod.DELETE,request,String.class);
            assertEquals(res.getStatusCode(),HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            assertEquals("400 : \"Wrong ID\"",e.getMessage());
        }


    }

}