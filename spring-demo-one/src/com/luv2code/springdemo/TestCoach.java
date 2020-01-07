package com.luv2code.springdemo;

public class TestCoach implements Coach {
	
	private FortuneService fortuneService;

	
	public TestCoach() {
		
	}
	
	public TestCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "run 3k everyday";
	}

	@Override
	public String getDailyFortune() {
		return "I'm lucky tonight" + fortuneService.getFortune();
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void destroy() {
		System.out.println("destroys");
	}
}
