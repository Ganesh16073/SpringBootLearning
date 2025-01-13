package com.main.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="showtime")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Showtime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showtime_seq")
    @SequenceGenerator(name = "showtime_seq", sequenceName = "showtime_sequence", initialValue = 1, allocationSize = 1)
//	@Column(name="showtime_Id")
	private Integer showtimeId;
	@Nonnull
	private String name;
	@Nonnull
	private String location;
	@Nonnull
	private String contact;
	
	 @ManyToMany
	 @JoinTable(
	     name = "showtime_seats", // Junction table name
	     joinColumns = @JoinColumn(name = "showtime_id"), // Foreign key from Showtime
	     inverseJoinColumns = @JoinColumn(name = "seats_id") // Foreign key from Seats
	 )
	 private List<Seats> seats; // Many-to-Many relationship
	
	
}
