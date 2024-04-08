package com.udemy.Springcoredemo.rest;

import com.udemy.Springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCoach;
    //define a constructor for the dependency injection

   @Autowired
   public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theanotherCoach){
       System.out.println("In constructor: " + getClass().getSimpleName());

       myCoach=theCoach;
       anotherCoach=theanotherCoach;
   }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
       return "Comparing beans: mycoach ==anothercoach, " + (myCoach==anotherCoach);
    }
}
