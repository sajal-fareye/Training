package com.fareye.training;

import com.fareye.training.model.Singleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingApplication {

    public static void main(String[] args){
        SpringApplication.run(TrainingApplication.class, args);
        System.out.println("Heloo world");

//        Singleton obj1 = Singleton.getInstance();
//        Singleton obj2 = Singleton.getInstance();
//
//        if(obj2==obj1)
//            System.out.println("This is same");
//        else
//            System.out.println("This is not same");


    }

}
