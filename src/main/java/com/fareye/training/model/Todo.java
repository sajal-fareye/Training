package com.fareye.training.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter@Setter
public class Todo {

    private int todoid;
    private LocalDate douDate;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String body;
    private String title;
    private String status;
    private User user;

    Todo(){
        this.createdDate = LocalDate.now();
    }
}
