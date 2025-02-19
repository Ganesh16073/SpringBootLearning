package com.main.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Table(name="customer")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {

	@Id
	@Column(name="CUSTOMER_ID",length=30)
	@SequenceGenerator(name="gen1", sequenceName = "CNO_SEQ", initialValue=1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer id;
	@Nonnull
	@Column(name="CUSTOMER_NAME", length=30)
	private String name;
	@Column(name="CUSTOMER_ADDRESS", length=50)
	@Nonnull
	private String cusAdd;
	@Column(name="BILL_AMOUNT")
	@Nonnull
	private double bilAmt;
}
