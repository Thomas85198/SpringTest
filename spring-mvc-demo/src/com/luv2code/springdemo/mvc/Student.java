package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	private String lastName;
	
	private String country;
	
	private LinkedHashMap<String, String> countryOption;
	
	private String favoriteLanguage;
	
	private LinkedHashMap<String, String> favoriteLanguageOption;
	
	private String[] operatingSystems;
	
	public Student() {
		
		// populate country option: used ISO country code
		countryOption = new LinkedHashMap<>();
		
		// populate favoriteLanguage option
		favoriteLanguageOption = new LinkedHashMap<>();
		
		countryOption.put("BR", "Brazil");
		countryOption.put("FR", "France");
		countryOption.put("DE", "Germany");
		countryOption.put("IN", "India");
		countryOption.put("US", "United States of America");
		countryOption.put("TW", "Taiwan");
		
		favoriteLanguageOption.put("Java", "Java");
		favoriteLanguageOption.put("C#", "C#");
		favoriteLanguageOption.put("PHP", "PHP");
		favoriteLanguageOption.put("Ruby", "Ruby");
		
	}
	
	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public LinkedHashMap<String, String> getCountryOption() {
		return countryOption;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}



	public LinkedHashMap<String, String> getFavoriteLanguageOption() {
		return favoriteLanguageOption;
	}



	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
	
	
	
	
}