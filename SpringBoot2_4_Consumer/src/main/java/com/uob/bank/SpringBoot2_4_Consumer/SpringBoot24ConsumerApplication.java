package com.uob.bank.SpringBoot2_4_Consumer;

import com.uob.bank.SpringBoot2_4_Consumer.model.response.Greetings;
import com.uob.bank.SpringBoot2_4_Consumer.model.response.Quote;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBoot24ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot24ConsumerApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate){
		return args -> {
			Greetings greetings = restTemplate.getForObject(
					"http://localhost:8081/greeting?name=Vipin", Greetings.class
					);
			System.out.println(greetings.toString());

			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class
			);
			System.out.println(quote.toString());

		};
	}
}
