package com.main.model;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public final class SgBat implements ICricketBat{

	public SgBat() {
		System.out.println("SgBat.SgBat()");
	}

	@Override
	public int scoreRuns() {
		System.out.println("SgBat.scoreRuns()");
		int score=new Random().nextInt(300);
		return score;
	}
	
	
	

}
