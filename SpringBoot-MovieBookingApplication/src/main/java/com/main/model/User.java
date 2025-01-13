package com.main.model;

import java.util.Date;
import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
	private Integer userId;
	@Nonnull
	private String username;
	@Nonnull
	private String email;
	@Nonnull
	private String password;
	@Nonnull
	private String phone;
	@Nonnull
	private Date registerDate;
	
	@OneToMany(mappedBy = "user")
	private List<Booking> bookings;

}
