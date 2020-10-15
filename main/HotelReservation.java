package com.blz.hotelreservationsystem.main;

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

	public static void main(String[] args) {
		System.out.println("Welcome to HOTEL RESERVATION Program.");
	}
}