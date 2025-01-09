package com.main.model;

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
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="seats")
@AllArgsConstructor
@NoArgsConstructor
public class Seats {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seats_seq")
    @SequenceGenerator(name = "seats_seq", sequenceName = "seats_sequence", allocationSize = 1)
	private Integer seatId;
	@ManyToOne
    @JoinColumn(name = "showtime_id", referencedColumnName = "showtimeId", nullable = false)
	private Showtime showtime;
	private Integer seatNumber;
	private Integer isAvailable;
	
}
