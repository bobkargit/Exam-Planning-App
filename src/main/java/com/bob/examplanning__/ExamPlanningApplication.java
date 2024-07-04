package com.bob.examplanning__;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@SpringBootApplication
public class ExamPlanningApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamPlanningApplication.class, args);
        System.out.println("Hello");


    }

}
