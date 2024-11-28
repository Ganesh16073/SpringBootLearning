package com.first.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeasonFinder {
	
	@Autowired
	public LocalDate ld;
	
	public String findSeason()
	{
		int month=ld.getMonthValue();
		
		if(month>3 && month<6)
		{
			return "Summer season";
		}
		else if(month>=7 && month<=10)
		{
			return "Rainy Season";
		}
		else
		{
			return "Winter Season";
		}
	}

}
