package com.blz.hotelreservationsystem.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import java.util.ArrayList;

public class HotelReservationTest01 {

	// ADD RATES FOR REGULAR CUSTOMERS ON WEEKDAYS AND WEEKENDS IN EACH HOTEL
	@Test
	public void hotelTestUC03() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110, 90);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150, 50);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220, 150);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		assertTrue(hotelList.get(0).getRegularCustomerRateOnWeekend() == 90);
		assertTrue(hotelList.get(1).getRegularCustomerRateOnWeekend() == 50);
		assertTrue(hotelList.get(2).getRegularCustomerRateOnWeekend() == 150);
	}
}