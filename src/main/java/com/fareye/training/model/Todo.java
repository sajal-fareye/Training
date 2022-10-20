package com.fareye.training.model;

import com.fareye.training.helper.TodoValidation;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class Todo {

    private int todoId;
    private LocalDate douDate;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String body;

//    @TodoValidation()
//    private String title;
//    @NotNull(message = "Status should not be null")
//    private String status;
    private User user;

    Todo() {
        this.createdDate = LocalDate.now();
    }
}
