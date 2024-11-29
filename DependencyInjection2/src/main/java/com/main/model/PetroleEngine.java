package com.main.model;

import org.springframework.stereotype.Component;

@Component
public class PetroleEngine implements IEngine{

	public PetroleEngine() {
		System.out.println("PetroleEngine.PetroleEngine() =>> Constructor");
	}

	@Override
	public void start() {
		System.out.println("PetroleEngine.start() =>> Starting The Petrole Engine");
		
	}

	@Override
	public void stop() {
		System.out.println("PetroleEngine.stop() =>> Switching Off Petrole Engine");
		
	}

}
