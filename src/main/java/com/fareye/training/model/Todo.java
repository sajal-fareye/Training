package com.fareye.training.model;

import com.fareye.training.helper.TodoValidation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer todoid;
//    private LocalDate douDate;
//    private LocalDate createdDate;
//    private LocalDate modifiedDate;
    private String body;

//    @TodoValidation()
   private String title;
//    @NotNull(message = "Status should not be null")
//    private String status;
    private Integer userid;

//    Todo() {
//        this.createdDate = LocalDate.now();
//    }
}
