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

@Entity
@Data
@Table(name="feedback")
@NoArgsConstructor
@AllArgsConstructor
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
    @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_sequence", allocationSize = 1)
	@Column(name="feedback_id")
	private Integer feedbackId;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "userId",nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "movie_id", referencedColumnName = "movieId", nullable = false)
	private Movie movie;
	
	@Nonnull
	private String feedBack_text;
	
	@Nonnull
	private Integer rating;
	
	

}
