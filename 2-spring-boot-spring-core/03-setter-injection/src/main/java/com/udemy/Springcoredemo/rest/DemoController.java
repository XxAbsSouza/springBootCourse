package com.udemy.Springcoredemo.rest;

import com.udemy.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;
    //define a constructor for the dependency injection

   @Autowired
   public void setCoach(Coach theCoach){
       myCoach=theCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
