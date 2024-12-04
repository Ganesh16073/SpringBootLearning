package com.main.DTO.copy;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@ConfigurationProperties(prefix = "com.student.data")
public class Student {
	
	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private String city;
	private String department;
	

}
