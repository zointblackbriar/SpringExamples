package com.tudresden.springreservation.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//CREATE TABLE ROOM(
//		  ROOM_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
//		  NAME VARCHAR(16) NOT NULL,
//		  ROOM_NUMBER CHAR(2) NOT NULL UNIQUE,
//		  BED_INFO CHAR(2) NOT NULL
//		);

@Entity
@Table(name="ROOM")
public class Room {
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoomNumber() {
		return number;
	}
	public void setRoomNumber(String number) {
		this.number = number;
	}
	public String getBedInfo() {
		return bedInfo;
	}
	public void setBedInfo(String bedInfo) {
		this.bedInfo = bedInfo;
	}
	@Id
	@Column(name="ROOM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="ROOM_NUMBER")
	private String number;
	@Column(name="BED_INFO")
	private String bedInfo;
}
