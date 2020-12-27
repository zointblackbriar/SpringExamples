package com.tudresden.springreservation.data.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//CREATE TABLE RESERVATION(
//		  RESERVATION_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
//		  ROOM_ID BIGINT NOT NULL,
//		  GUEST_ID BIGINT NOT NULL,
//		  RES_DATE DATE
//		);

@Entity
@Table(name="RESERVATION")
public class Reservation {
	
	public long getReservationID() {
		return reservationID;
	}
	public void setReservationID(long reservationID) {
		this.reservationID = reservationID;
	}
	public long getRoomID() {
		return roomID;
	}
	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}
	public long getGuestID() {
		return guestID;
	}
	public void setGuestID(long guestID) {
		this.guestID = guestID;
	}
	public Date getReservationDate() {
		return date;
	}
	public void setReservationDate(Date date) {
		this.date = date;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //for auto increment
	@Column(name="RESERVATION_ID")
	private long reservationID;
	@Column(name="ROOM_ID")
	private long roomID;
	@Column(name="GUEST_ID")
	private long guestID;
	@Column(name="RES_DATE")
	private Date date;
	
}	
