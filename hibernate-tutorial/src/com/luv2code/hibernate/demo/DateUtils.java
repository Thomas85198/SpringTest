package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	// The date formatter
	// - dd: day in month (number)
	// - MM: month in year (number)
	// - yyyy: year
	//
	// Search for details: simpleDataFormat
	//
	//
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	// read a date string and parse/convert to a date
	// 是用java.util.Date
	// 錯誤類型是ParseException
	public static Date parseDate(String dateStr) throws ParseException {
		Date theDate = formatter.parse(dateStr);
		
		return theDate;
	}
	
	// read a date and format/convert to a string
	public static String formatDate(Date theDate) {
		String result = null;
		
		if(theDate != null) {
			result = formatter.format(theDate);
		}
		return result;
	}
	
}
