package com.blz.hotelreservationsystem.test;

import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

public class HotelReservationTest01 {

	// ADD SPECIAL RATES FOR REWARD CUSTOMERS ON WEEKDAYS AND WEEKENDS IN EACH HOTEL
	@Test
	public void hotelTestUC09() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110, 90, 80, 80, 3);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150, 50, 110, 50, 4);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220, 150, 100, 40, 5);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		assertTrue(hotelList.get(0).getRewardCustomerRateOnWeekday() == 80);
		assertTrue(hotelList.get(1).getRewardCustomerRateOnWeekday() == 110);
		assertTrue(hotelList.get(2).getRewardCustomerRateOnWeekday() == 100);
		assertTrue(hotelList.get(0).getRewardCustomerRateOnWeekend() == 80);
		assertTrue(hotelList.get(1).getRewardCustomerRateOnWeekend() == 50);
		assertTrue(hotelList.get(2).getRewardCustomerRateOnWeekend() == 40);
	}
}