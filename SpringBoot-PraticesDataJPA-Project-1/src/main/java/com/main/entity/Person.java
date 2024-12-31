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

@Entity
@Table(name = "Person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "Per_seq",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen1")
	@Column(name="p_id")
	private Integer pId;
	@Nonnull
	@Column(name="p_name")
	private String pName;
	@Nonnull
	@Column(name=" p_address")
	private String  pAddress;
	@Nonnull
	@Column(name="p_salary")
	private Double pSalary;

}
