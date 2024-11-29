package com.main.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Vehical {
	
	public Vehical() {
		System.out.println("Vehical.Vehical() =>> Constructor");
	}
	
	@Autowired
	@Qualifier("CNGEngine")
	private IEngine eng;

	public void journey(String sourcePlace, String destPlace)
	{
		System.out.println("Vehical.journey()");
		eng.start();
		System.out.println("Journey Starts At =>> "+sourcePlace);
		System.out.println("Journy is going on..........");
		eng.stop();
		System.out.println("Journy ends at =>> "+destPlace);
		
	}
	
	
		

}
