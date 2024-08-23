package com.springmvc.mock.models;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "release_date", updatable = false)
	private LocalDateTime release_date;
	
	@PrePersist
	protected void onCreate() {
		release_date = LocalDateTime.now();
	}
	
	@Column(name = "duration")
	private Long duration;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "movie")
	private List<Showtime> showtime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public LocalDateTime getRelease_date() {
		return release_date;
	}

	public void setRelease_date(LocalDateTime release_date) {
		this.release_date = release_date;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Showtime> getShowtime() {
		return showtime;
	}

	public void setShowtime(List<Showtime> showtime) {
		this.showtime = showtime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
