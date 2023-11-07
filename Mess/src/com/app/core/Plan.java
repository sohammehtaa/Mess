package com.app.core;

public enum Plan {
	MONTHLY(3000,1),QUARTERLY(11700,3),HALF_YEARLY(17500,6),YEARLY(32000,12);
	
	private double amount;
	private int months;

	public int getMonths() {
		return months;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	private Plan(double amount,int months) {
		this.amount = amount;
		this.months=months;
	}
	
	
}
