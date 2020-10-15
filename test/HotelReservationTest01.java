package com.blz.hotelreservationsystem.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationTest01 {

	// ADD HOTEL NAMES AND RATES FOR REGULAR CUSTOMERS IN EACH HOTEL
	@Test
	public void hotelTestUC01() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		assertEquals(hotelList.get(0).getHotelName(), "Lakewood");
		assertEquals(hotelList.get(1).getHotelName(), "Bridgewood");
		assertEquals(hotelList.get(2).getHotelName(), "Ridgewood");
		assertTrue(hotelList.get(0).getRegularCustomerRate() == 110);
		assertTrue(hotelList.get(1).getRegularCustomerRate() == 150);
		assertTrue(hotelList.get(2).getRegularCustomerRate() == 220);
	}

	// REGULAR CUSTOMER DATE RANGE ENTRY GIVES CHEAPEST HOTEL AVAILABLE ON WEEKDAYS
	@Test
	public void hotelTestUC02() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Date-Range to get the cheapest hotel available:"
				+ "\n(Enter in (ddMMMyyyy) format only, seperated with a comma(,))");
		int numOfDays = HotelReservation.timeFormat(input.nextLine());
		ArrayList<HotelReservation> cheapestHotels = HotelReservation.findCheapestHotel(hotelList);
		double totalRate = cheapestHotels.get(0).getRegularCustomerRate() * numOfDays;
		System.out.print(cheapestHotels.get(0).getHotelName());
		for (int i = 1; i < cheapestHotels.size(); i++) {
			System.out.print(" and " + cheapestHotels.get(i).getHotelName());
		}
		System.out.print("\tTotal Rate:" + totalRate);
		input.close();
		assertTrue(hotel1.getRegularCustomerRate() * numOfDays == totalRate);
	}
}