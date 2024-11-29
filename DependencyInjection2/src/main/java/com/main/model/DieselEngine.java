package com.main.model;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements IEngine{
	
	public DieselEngine() {
		System.out.println("DieselEngine.DieselEngine() =>> Constructor");
	}

	@Override
	public void start() {
		System.out.println("DieselEngine.start() =>> Starting Diesel Engine");
		
	}

	@Override
	public void stop() {
		System.out.println("DieselEngine.stop() =>> Switching off Diesel Engine");
	}

}
