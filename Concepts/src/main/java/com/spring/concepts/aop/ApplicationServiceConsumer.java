package com.spring.concepts.aop;

import com.spring.concepts.aop.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServiceConsumer {

    @Autowired
    ApplicationService applicationService;

    public void consumerMethod(){
        // Next statement is JoinPoint --- Any point in our application program where method execution happens
        applicationService.method1();
    }

    public void consumerMethod2(){
        //JoinPoint
        applicationService.method2();
    }

}
