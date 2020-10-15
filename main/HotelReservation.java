package com.blz.hotelreservationsystem.main;

import java.util.ArrayList;

public class HotelReservation {
	private final String HOTEL_NAME;
	private final double REGULAR_RATE_WEEKDAY;
	private final double REGULAR_RATE_WEEKEND;

	public HotelReservation(String HOTEL_NAME, double REGULAR_RATE_WEEKDAY, double REGULAR_RATE_WEEKEND) {
		this.HOTEL_NAME = HOTEL_NAME;
		this.REGULAR_RATE_WEEKDAY = REGULAR_RATE_WEEKDAY;
		this.REGULAR_RATE_WEEKEND = REGULAR_RATE_WEEKEND;
	}

	public String getHotelName() {
		return this.HOTEL_NAME;
	}

	public double getRegularCustomerRateOnWeekday() {
		return this.REGULAR_RATE_WEEKDAY;
	}

	public double getRegularCustomerRateOnWeekend() {
		return this.REGULAR_RATE_WEEKEND;
	}

	public static int timeFormat(String dateToBeFormatted) {
		String[] dates = dateToBeFormatted.split(",");
		return dates.length;
	}

	public static ArrayList<HotelReservation> findCheapestHotel(ArrayList<HotelReservation> hotelList) {
		double leastRateOnWeekDay = hotelList.get(0).getRegularCustomerRateOnWeekday();
		ArrayList<HotelReservation> cheapestHotels = new ArrayList<>();
		for (HotelReservation hotel : hotelList) {
			if (leastRateOnWeekDay > hotel.getRegularCustomerRateOnWeekday()) {
				leastRateOnWeekDay = hotel.getRegularCustomerRateOnWeekday();
			}
		}
		for (HotelReservation hotel : hotelList) {
			if (leastRateOnWeekDay == hotel.getRegularCustomerRateOnWeekday()) {
				cheapestHotels.add(hotel);
			}
		}
		return cheapestHotels;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to HOTEL RESERVATION Program.");
	}
}