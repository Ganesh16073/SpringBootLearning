package com.main.model;

import java.util.List;

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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="lang_and_genre_join")
public class LangAndGenreJoin {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "langandgenrejoin_seq")
    @SequenceGenerator(name = "langandgenrejoin_seq", sequenceName = "lang_and_genre_join_sequence",initialValue = 1, allocationSize = 1)
	private Integer lgjId; 
	
	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "languageId")
	private Language language;
	@ManyToOne
	@JoinColumn(name = "genres_id", referencedColumnName = "genresId")
	private Genres genres;
}
