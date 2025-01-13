package com.main.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
	private double price;

    @ManyToMany(mappedBy = "seats") // Many-to-Many relationship (mapped by the "seats" in Showtime)
    private List<Showtime> showtimes; // Reference to parent Showtime

}
