package com.udemy.Springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define out init method
    @PostConstruct
    public void nomealeatorio(){
        System.out.println("Em construção(): " + getClass().getSimpleName() );
    }
    //define our destroy method
    @PreDestroy
    public void nomealeatorio2(){
        System.out.println("Em Destruição(): " + getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :)))";
    }
}
