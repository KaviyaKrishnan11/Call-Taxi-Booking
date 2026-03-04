package com.kce.service;
import java.util.*;

import com.kce.bean.Booking;
import com.kce.bean.Taxi;

public class TaxiService {

    private List<Taxi> taxis = new ArrayList<>();
    private int bookingCounter = 1;

    public TaxiService(int taxiCount) {
        for (int i = 1; i <= taxiCount; i++) {
            taxis.add(new Taxi(i));
        }
    }

    public void bookTaxi(int customerId, char pickup, char drop, int pickupTime) {

        Taxi allottedTaxi = null;
        int minDistance = Integer.MAX_VALUE;

        for (Taxi taxi : taxis) {

            if (taxi.getFreeTime() <= pickupTime) {

                int distance = Math.abs(taxi.getCurrentLocation() - pickup);

                if (distance < minDistance) {
                    minDistance = distance;
                    allottedTaxi = taxi;
                }
                else if (distance == minDistance) {
                    if (taxi.getTotalEarnings() < allottedTaxi.getTotalEarnings()) {
                        allottedTaxi = taxi;
                    }
                }
            }
        }

        if (allottedTaxi == null) {
            System.out.println("Booking Rejected. No Taxi Available.");
            return;
        }

        int travelPoints = Math.abs(drop - pickup);
        int distanceKm = travelPoints * 15;
        int travelTime = travelPoints * 1;

        int amount = calculateFare(distanceKm);

        int dropTime = pickupTime + travelTime;

        Booking booking = new Booking(
                bookingCounter++, customerId,
                pickup, drop,
                pickupTime, dropTime,
                amount
        );

        allottedTaxi.addBooking(booking);
        allottedTaxi.addEarnings(amount);
        allottedTaxi.setCurrentLocation(drop);
        allottedTaxi.setFreeTime(dropTime);

        System.out.println("Taxi can be allotted. Taxi-" +
                allottedTaxi.getTaxiId() + " is allotted.");
    }

    private int calculateFare(int distance) {

        if (distance <= 5)
            return 100;
        else
            return 100 + (distance - 5) * 10;
    }

    public void displayTaxiDetails() {

        for (Taxi taxi : taxis) {

            System.out.println("\nTaxi-" + taxi.getTaxiId() +
                    " Total Earnings: Rs. " + taxi.getTotalEarnings());

            System.out.println("BookingID CustomerID From To Pickup Drop Amount");

            for (Booking b : taxi.getBookings()) {

                System.out.println(
                        b.getBookingId() + "        " +
                        b.getCustomerId() + "        " +
                        b.getPickup() + "    " +
                        b.getDrop() + "    " +
                        b.getPickupTime() + "      " +
                        b.getDropTime() + "     " +
                        b.getAmount()
                );
            }
        }
    }
}
