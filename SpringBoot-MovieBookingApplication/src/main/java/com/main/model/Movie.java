package com.main.model;

import java.time.LocalDate;
import java.time.LocalTime;

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
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq", sequenceName = "movie_sequence", initialValue = 1, allocationSize = 1)
//	@Column(name = "movie_id")
	private Integer movieId;
	@Nonnull
	private String title;
	@Nonnull
	private String genre;
	@Nonnull
	private LocalTime duration;
	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "languageId")
	private Language language;
	@ManyToOne
	@JoinColumn(name = "genres_id", referencedColumnName = "genresId")
	private Genres genres;
	@Nonnull
	private LocalDate releaseDate;
}
