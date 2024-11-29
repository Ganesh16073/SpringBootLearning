package com.main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public final class Cricketer {
	
	@Autowired
	@Qualifier("bat")
	private ICricketBat b;

	public Cricketer() {
		System.out.println("Cricketer.Cricketer()");
	}
	
	public String Batting()
	{
		System.out.println("Cricketer.Batting()");
		int run=b.scoreRuns();
		return "The Scored Run are =>> "+run;
	}
	
	

}
