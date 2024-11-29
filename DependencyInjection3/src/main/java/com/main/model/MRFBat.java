package com.main.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component	
public final class MRFBat implements ICricketBat{

	public MRFBat() {
		System.out.println("MRFBat.MRFBat()");
		
	}

	@Override
	public int scoreRuns() {
		System.out.println("MRFBat.scoreRuns()");
		
		int score=new Random().nextInt(200);
		return score;
	}

}
