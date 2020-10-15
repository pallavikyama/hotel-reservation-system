package com.blz.hotelreservationsystem.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import java.util.ArrayList;
import java.util.Scanner;

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

	// REGULAR CUSTOMER DATE RANGE ENTRY GIVES CHEAPEST HOTEL AVAILABLE ON WEEKDAYS AND WEEKENDS
	@Test
	public void hotelTestUC04() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110, 90);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150, 50);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220, 150);
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		Scanner input = new Scanner(System.in);
		boolean x;
		do {
			System.out.println("Enter Date-Range to get the cheapest hotel available:"
					+ "\n(Enter in (ddMMMyyyy) format only, seperated with a comma(,))");
			try {
				x = true;
				HotelReservation.timeFormat(input.nextLine());
			} catch (Exception e) {
				x = false;
				System.out.println("Entered invalid dates. Try again.");
			}
		} while (!x);
		ArrayList<HotelReservation> cheapestHotels = HotelReservation.findCheapestHotel(hotelList);
		double totalRate = cheapestHotels.get(0).getRegularCustomerRateOnWeekday()
				* HotelReservation.numOfWeekdayBookings
				+ cheapestHotels.get(0).getRegularCustomerRateOnWeekend() * HotelReservation.numOfWeekendBookings;
		System.out.print(cheapestHotels.get(0).getHotelName());
		for (int i = 1; i < cheapestHotels.size(); i++) {
			System.out.print(" and " + cheapestHotels.get(i).getHotelName());
		}
		System.out.print("    Total Rate:" + totalRate);
		input.close();
	}
}