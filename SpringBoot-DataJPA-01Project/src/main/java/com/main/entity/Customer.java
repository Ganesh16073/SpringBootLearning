package com.main.entity;

import jakarta.annotation.Nonnull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor	
public class Customer {
	
	@Id
	@Column(name="CUSTOMER_ID",length=30)
	@SequenceGenerator(name="gen1", sequenceName = "CNO_SEQ", initialValue = 1, allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer id;
	
//	@Transient usted to insert null valuse
	@Nonnull
	@Column(name="CUSTOMER_NAME", length=30)
	private String name;
	@Column(name="CUSTOMER_ADDRESS", length=50)
	@Nonnull
	private String cAdd;
	@Column(name="BILL_AMOUNT")
	@Nonnull
	private double billAmt;

}
