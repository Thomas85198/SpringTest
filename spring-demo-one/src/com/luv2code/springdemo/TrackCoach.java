package com.luv2code.springdemo;

public class TrackCoach implements Coach {

	// This is follow FortuneService interface
	// Therefore in here fortuneService this field can only use getFortune the function
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {	
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Joust Do It " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStratupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
	}
	
	
}
