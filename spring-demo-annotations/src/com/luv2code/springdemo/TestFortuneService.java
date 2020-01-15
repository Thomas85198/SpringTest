package com.luv2code.springdemo;



public class TestFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "這邊是fortuneService的測試";
	}

}
