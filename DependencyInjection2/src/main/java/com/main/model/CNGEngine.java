package com.main.model;

import org.springframework.stereotype.Component;

@Component
public class CNGEngine implements IEngine{
	

	public CNGEngine() {
		System.out.println("CNGEngine.CNGEngine()");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine.start() =>> Starting the CNG Engine");
	}

	@Override
	public void stop() {
		System.out.println("CNGEngine.stop() =>> Switching off CNG Engine");
	}

}
