package com.main.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
public class Employee {

	private Integer eno;
	private String ename;
	private String job;
	private Double salary;
	private Integer deptno;
	private Double grossSalary;
	private Double netSalary;

}