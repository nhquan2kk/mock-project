package com.springmvc.mock.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "screeningroom")
public class ScreeningRoom {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_name")
    private String room_name;

    @Column(name = "total_seat")
    private int totalSeat;

    @OneToMany(mappedBy="screeningroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seat> seat;

    @OneToMany(mappedBy = "screeningroom", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Showtime> showtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoom_name() {
        return room_name;
    }

    public void setRoom_name(String room_name) {
        this.room_name = room_name;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public List<Showtime> getShowtime() {
        return showtime;
    }

    public void setShowtime(List<Showtime> showtime) {
        this.showtime = showtime;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }

    public void calculateTotalSeat() {
        if (seat != null) {
            this.totalSeat = seat.stream()
                .mapToInt(s -> s.getRow_number() * s.getColumn_number())
                .sum();
        } else {
            this.totalSeat = 0;
        }
    }
}