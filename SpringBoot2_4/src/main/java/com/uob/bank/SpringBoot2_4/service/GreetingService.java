package com.uob.bank.SpringBoot2_4.service;

import com.uob.bank.SpringBoot2_4.model.Greetings;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class GreetingService {
    private static AtomicInteger counter = new AtomicInteger();
    private static String template = "Hello %s!";

    @GetMapping("/greeting")
    public Greetings greeting(@RequestParam(value = "name", defaultValue = "World") String name){
       return new Greetings(counter.incrementAndGet(), String.format(template, name));
    }

}
