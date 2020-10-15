package com.blz.hotelreservationsystem.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import java.util.ArrayList;

public class HotelReservationTest01 {

	// ADD RATINGS FOR EACH HOTEL
	@Test
	public void hotelTestUC05() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110, 90, 3);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150, 50, 4);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220, 150, 5);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		assertTrue(hotelList.get(0).getRating() == 3);
		assertTrue(hotelList.get(1).getRating() == 4);
		assertTrue(hotelList.get(2).getRating() == 5);
	}
}