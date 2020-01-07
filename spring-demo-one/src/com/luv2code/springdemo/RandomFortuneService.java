package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	// create an array of strings
	private String[] data = {
			"今天天氣真好",
			"明天又要上課，好煩",
			"Java好難"
	};
	
	// create a random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() {
		// pick a random string from the array
		int index = myRandom.nextInt(3);
		
		String theFortune = data[index];
		
		return theFortune;
	}

}
