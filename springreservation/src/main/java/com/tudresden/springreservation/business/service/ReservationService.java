package com.tudresden.springreservation.business.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tudresden.springreservation.business.domain.RoomReservation;
import com.tudresden.springreservation.data.entity.Guest;
import com.tudresden.springreservation.data.entity.Reservation;
import com.tudresden.springreservation.data.entity.Room;
import com.tudresden.springreservation.data.repository.GuestRepository;
import com.tudresden.springreservation.data.repository.ReservationRepository;
import com.tudresden.springreservation.data.repository.RoomRepository;

@Service
public class ReservationService {
	private RoomRepository roomRepository; 
	private GuestRepository guestRepository; 
	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository, ReservationRepository reservationRepository) {
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}
	
	public List<RoomReservation> getRoomReservations(Date date) {
		//Iterable Room
		Iterable<Room> rooms = this.roomRepository.findAll();
		Map<Long, RoomReservation> roomReservationMap = new HashMap<Long, RoomReservation>();
		rooms.forEach(room -> {
			RoomReservation roomReservation = new RoomReservation();
			roomReservation.setRoomId(room.getId());
			roomReservation.setRoomName(room.getName());
			roomReservation.setRoomNumber(room.getRoomNumber());
			roomReservationMap.put(room.getId(), roomReservation);  //add into the map
		});
		
		@SuppressWarnings("deprecation")
		Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getDate()));
		if(null != reservations) {
			reservations.forEach(reservation -> {
				//Possible bug could be here
				Optional<Guest> guest = this.guestRepository.findById(reservation.getGuestID());
				if(null != reservations) {
					RoomReservation roomReservation = roomReservationMap.get(reservation.getReservationID());
					roomReservation.setDate(date);
					roomReservation.setFirstName(guest.get().getFirstName());
					roomReservation.setLastName(guest.get().getLastName());
					roomReservation.setGuestId(guest.get().getId());
				}
			});
		}
		
		List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();
		for(long roomId: roomReservationMap.keySet()) {
			//get all keys of the map
			roomReservations.add(roomReservationMap.get(roomId));
		}
		System.out.println("RoomReservation List: " + roomReservations);
		return roomReservations;
	}
}
