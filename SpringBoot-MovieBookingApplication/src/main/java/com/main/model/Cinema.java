package com.main.model;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cinema")
public class Cinema {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cinema_seq")
    @SequenceGenerator(name = "cinema_seq", sequenceName = "cinema_sequence", initialValue = 1, allocationSize = 1)
//	@Column(name = "cinema_id")
	private Integer CinemaId;
	@Nonnull
	private String name;	
	@Nonnull
	private String location;
	@Nonnull
	private String contact;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "movieId", nullable = false)	
	private Movie movie;

}
