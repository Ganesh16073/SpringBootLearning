package com.main.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public final class SSBat implements ICricketBat{

	public SSBat() {
		System.out.println("SSBat.SSBat()");
	}

	@Override
	public int scoreRuns() {
		System.out.println("SSBat.scoreRuns()");
		
		int score=new Random().nextInt(400);
		return score;
	}
	
	

}
