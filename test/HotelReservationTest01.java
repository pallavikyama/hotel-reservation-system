package com.blz.hotelreservationsystem.test;

import org.junit.Test;
import com.blz.hotelreservationsystem.main.HotelReservation;
import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationTest01 {

	// REGULAR CUSTOMER DATE RANGE ENTRY GIVES CHEAPEST, BEST RATED HOTEL AVAILABLE
	@Test
	public void hotelTestUC06() {
		ArrayList<HotelReservation> hotelList = new ArrayList<>();
		HotelReservation hotel1 = new HotelReservation("Lakewood", 110, 90, 3);
		HotelReservation hotel2 = new HotelReservation("Bridgewood", 150, 50, 4);
		HotelReservation hotel3 = new HotelReservation("Ridgewood", 220, 150, 5);
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
		System.out.print(HotelReservation.findBestRatedHotel(cheapestHotels).getHotelName() + "    Rating:"
				+ HotelReservation.findBestRatedHotel(cheapestHotels).getRating() + "    Total Rate:" + totalRate);
		input.close();
	}
}