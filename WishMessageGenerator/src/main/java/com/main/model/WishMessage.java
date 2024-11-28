package com.main.model;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishMessage {
	
	@Autowired
	public LocalTime lt;
	
	public String getMessage()
	{
		int hour=lt.getHour();
		if(hour>=12 && hour<=4)
		{
			return "Good Afternoon";
		}
		else if(hour>4 && hour<24)
		{
			return "Good Night";
		}
		else
		{
			return "Good Mornig";
		}
	}

}
