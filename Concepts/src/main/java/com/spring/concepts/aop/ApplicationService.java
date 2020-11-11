package com.spring.concepts.aop;

import com.sun.deploy.util.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class ApplicationService {

    public String method1(){
        System.out.println("Method1");
        return StringUtils.trimWhitespace("xyz");
    }
    public void method2(){
        System.out.println("Method2");
    }

}
