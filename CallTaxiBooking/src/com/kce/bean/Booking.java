package com.kce.bean;
public class Booking {
    private int bookingId;
    private int customerId;
    private char pickup;
    private char drop;
    private int pickupTime;
    private int dropTime;
    private int amount;
    public Booking(int bookingId, int customerId, char pickup, char drop,int pickupTime, int dropTime, int amount) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.pickup = pickup;
        this.drop = drop;
        this.pickupTime = pickupTime;
        this.dropTime = dropTime;
        this.amount = amount;
    }

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public char getPickup() {
		return pickup;
	}

	public void setPickup(char pickup) {
		this.pickup = pickup;
	}

	public char getDrop() {
		return drop;
	}

	public void setDrop(char drop) {
		this.drop = drop;
	}

	public int getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

	public int getDropTime() {
		return dropTime;
	}

	public void setDropTime(int dropTime) {
		this.dropTime = dropTime;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
    

}
