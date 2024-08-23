package com.springmvc.mock.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name  = "rownumber")
	private int rownumber;
	
	@Column(name = "columnnumber")
	private int columnnumber;
	
	@ManyToOne
	@JoinColumn(name = "screening_room_id")
	private ScreeningRoom screeningroom;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRow_number() {
		return rownumber;
	}

	public void setRow_number(int row_number) {
		this.rownumber = row_number;
	}

	public int getColumn_number() {
		return columnnumber;
	}

	public void setColumn_number(int column_number) {
		this.columnnumber = column_number;
	}

	public ScreeningRoom getScreeningroom() {
		return screeningroom;
	}

	public void setScreeningroom(ScreeningRoom screeningroom) {
		this.screeningroom = screeningroom;
	}
	
	
}
