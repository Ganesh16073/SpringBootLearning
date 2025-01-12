package com.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie_cinema_showtime_join")
public class MovieCinemaShowtimeJoin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "moviecinemashowtimejoin_seq")
    @SequenceGenerator(name = "moviecinemashowtimejoin_seq", sequenceName = "movie_cinema_showtime_join_sequence", initialValue = 1, allocationSize = 1)
    private Integer moviecinemashowtimejoinId;

    @ManyToOne
    @JoinColumn( name = "movie_id",referencedColumnName = "movieId")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "cinema_Id",  referencedColumnName = "cinemaId")
    private Cinema cinema;

    @ManyToOne
    @JoinColumn(name = "showtime_id",referencedColumnName = "showtimeId")
    private Showtime showtime;

}
