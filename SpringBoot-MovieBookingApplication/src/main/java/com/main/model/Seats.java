package com.main.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="seats")
@AllArgsConstructor
@NoArgsConstructor
public class Seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seats_seq")
	@SequenceGenerator(name = "seats_seq", sequenceName = "seats_sequence", allocationSize = 1)
//	@Column(name = "seats_id")
	private Long seatsId;
	private Integer seatNumber;
	private Integer isAvailable;
	
	@ManyToOne
    @JoinColumn(name = "showtime_id", referencedColumnName = "showtimeId", nullable = false)
	private Showtime showtime;
	
	private double price;
}
