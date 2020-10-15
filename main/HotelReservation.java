package com.blz.hotelreservationsystem.main;

import java.util.ArrayList;

public class HotelReservation {
	private final String HOTEL_NAME;
	private final double REGULAR_RATE;

	public HotelReservation(String HOTEL_NAME, double REGULAR_RATE) {
		this.HOTEL_NAME = HOTEL_NAME;
		this.REGULAR_RATE = REGULAR_RATE;
	}

	public String getHotelName() {
		return this.HOTEL_NAME;
	}

	public double getRegularCustomerRate() {
		return this.REGULAR_RATE;
	}

	public static int timeFormat(String dateToBeFormatted) {
		String[] dates = dateToBeFormatted.split(",");
		return dates.length;
	}

	public static ArrayList<HotelReservation> findCheapestHotel(ArrayList<HotelReservation> hotelList) {
		double leastRate = hotelList.get(0).getRegularCustomerRate();
		ArrayList<HotelReservation> cheapestHotels = new ArrayList<>();
		for (HotelReservation hotel : hotelList) {
			if (leastRate > hotel.getRegularCustomerRate()) {
				leastRate = hotel.getRegularCustomerRate();
			}
		}
		for (HotelReservation hotel : hotelList) {
			if (leastRate == hotel.getRegularCustomerRate()) {
				cheapestHotels.add(hotel);
			}
		}
		return cheapestHotels;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to HOTEL RESERVATION Program.");
	}
}