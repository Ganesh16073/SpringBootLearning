package com.main.model;

import java.util.Date;

import jakarta.annotation.Nonnull;
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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "booking_sequence",initialValue = 1, allocationSize = 1)
	private Integer bookingId;
	
	@ManyToOne
	@JoinColumn(name = "user_id") 
	private User user;

	@ManyToOne
	@JoinColumn(name="movie_cinema_showtime_join",referencedColumnName = "moviecinemashowtimejoinId")
	private MovieCinemaShowtimeJoin movieCinemaShowtimeJoin;
	
	@Nonnull
	private Date bookingDate;
	
	@Nonnull
	private double totalCost;
	

}
