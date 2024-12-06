package com.main.model;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Login {
	private int id;
	private String email;
	private String password;	

}
