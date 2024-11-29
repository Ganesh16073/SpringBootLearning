package com.main.model;

import org.springframework.stereotype.Component;

@Component
public class ElectricEngine implements IEngine{
	
	

	public ElectricEngine() {
		System.out.println("ElectricEngine.ElectricEngine() => Constructor");
	}

	@Override
	public void start() {
		System.out.println("ElectricEngine.start() =>> Starting the Engine");
		
	}

	@Override
	public void stop() {
		System.out.println("ElectricEngine.stop() =>> Switching off Engine");
		
		
	}

}
