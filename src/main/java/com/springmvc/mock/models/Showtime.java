package com.springmvc.mock.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "showtime")
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;  // Assuming you have a Movie entity

    @ManyToOne
    @JoinColumn(name = "screeningroom_id", nullable = false)
    private ScreeningRoom screeningroom;

    @Column(name = "showtime_date")
    private LocalDateTime showtimeDate;

    @Column(name = "fee")
    private Integer fee;

    @OneToMany(mappedBy = "showtime")
    private Set<Booking> bookings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ScreeningRoom getScreeningRoom() {
		return screeningroom;
	}

	public void setScreeningRoom(ScreeningRoom screeningRoom) {
		this.screeningroom = screeningRoom;
	}

	public LocalDateTime getShowtimeDate() {
		return showtimeDate;
	}

	public void setShowtimeDate(LocalDateTime showtimeDate) {
		this.showtimeDate = showtimeDate;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Set<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Booking> bookings) {
		this.bookings = bookings;
	}

    
}
