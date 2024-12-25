package com.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Customer")
@Data
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_NAME",length=30)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="CUSTOMER_NAME", length=30)
	private String name;
	@Column(name="CUSTOMER_ADDRESS", length=50)
	private String cAdd;
	@Column(name="BILL_AMOUNT")
	private double billAmt;

}
