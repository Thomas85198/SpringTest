package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan("com.luv2code.springdemo")
public class TestCoach implements Coach {

	@Autowired
	private FortuneService fortuneService;
	
	
	public TestCoach() {
		System.out.println("測試建構子");
	}
	
	public TestCoach(FortuneService f) {
		fortuneService = f;
	}

	@Override
	public String getDailyWorkout() {
		return "在這邊只是做測試getDailyWorkout";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
}
