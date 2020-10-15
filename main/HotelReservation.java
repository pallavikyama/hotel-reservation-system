package com.blz.hotelreservationsystem.main;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HotelReservation {
	private final String HOTEL_NAME;
	private final double REGULAR_RATE_WEEKDAY;
	private final double REGULAR_RATE_WEEKEND;
	public static int numOfWeekendBookings;
	public static int numOfWeekdayBookings;
	private float rating;

	public HotelReservation(String HOTEL_NAME, double REGULAR_RATE_WEEKDAY, double REGULAR_RATE_WEEKEND, float rating) {
		this.HOTEL_NAME = HOTEL_NAME;
		this.REGULAR_RATE_WEEKDAY = REGULAR_RATE_WEEKDAY;
		this.REGULAR_RATE_WEEKEND = REGULAR_RATE_WEEKEND;
		this.rating = rating;
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

	public float getRating() {
		return this.rating;
	}

	public static int timeFormat(String dateToBeFormatted) {
		String[] dates = dateToBeFormatted.split(",");
		for (String date : dates) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
			LocalDate time = LocalDate.parse(date, formatter);
			DayOfWeek dayOfWeek = time.getDayOfWeek();
			if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY)
				++numOfWeekendBookings;
		}
		numOfWeekdayBookings = dates.length - numOfWeekendBookings;
		return dates.length;
	}

	public static ArrayList<HotelReservation> findCheapestHotel(ArrayList<HotelReservation> hotelList) {
		double leastRate = hotelList.get(0).getRegularCustomerRateOnWeekday() * numOfWeekdayBookings
				+ hotelList.get(0).getRegularCustomerRateOnWeekend() * numOfWeekendBookings;
		ArrayList<HotelReservation> cheapestHotels = new ArrayList<>();
		for (HotelReservation hotel : hotelList) {
			double newRate = hotel.getRegularCustomerRateOnWeekday() * numOfWeekdayBookings
					+ hotel.getRegularCustomerRateOnWeekend() * numOfWeekendBookings;
			if (leastRate > newRate)
				leastRate = newRate;
		}
		for (HotelReservation hotel : hotelList) {
			double newRate = hotel.getRegularCustomerRateOnWeekday() * numOfWeekdayBookings
					+ hotel.getRegularCustomerRateOnWeekend() * numOfWeekendBookings;
			if (leastRate == newRate)
				cheapestHotels.add(hotel);
		}
		return cheapestHotels;
	}

	public static HotelReservation findBestRatedHotel(ArrayList<HotelReservation> cheapestHotels) {
		HotelReservation bestRatedHotel = cheapestHotels.get(0);
		for (HotelReservation hotel : cheapestHotels) {
			if (bestRatedHotel.getRating() < hotel.getRating())
				bestRatedHotel = hotel;
		}
		return bestRatedHotel;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to HOTEL RESERVATION Program.");
	}
}