package com.main.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="feedback_movie_user_join")
public class FeedbackMovieUserJoin {
	@Id
	private Integer id;
	
	 @ManyToOne
	 @JoinColumn(name = "movie_id", referencedColumnName = "movieId", nullable = false)
	 private Movie movie;
	
	 @ManyToOne
	 @JoinColumn(name = "feedback_id", referencedColumnName = "feedback_id", nullable = false)
	 private Feedback feedback;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
	 private User user;

}
