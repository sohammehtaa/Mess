package com.app.core;

import java.io.Serializable;
import java.time.LocalDate;

public class Customer implements Serializable{
	
	private static int customerId=001;
	private String firstName;
	private String lastName;
	private String email;
	
	public Customer(String email,String password) {
		super();
		this.email = email;
		this.password=password;
	}

	private String password;
	private String address;
	private LocalDate registerDate;
	private LocalDate planEndDate;
	private String phoneNo;
	private Plan plan;
	private double amount;
	
	public Customer(String firstName, String lastName, String email, String password, String address, String phoneNo, Plan plan, double amount) {
		super();
		customerId++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.registerDate = LocalDate.now();
		this.planEndDate = LocalDate.now().plusMonths(plan.getMonths());
		this.phoneNo = phoneNo;
		this.plan = plan;
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Customer [ firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", address=" + address + ", RegisterDate=" + registerDate
				+ ", planEndDate=" + planEndDate + ", phoneNo=" + phoneNo + ", plan=" + plan + ", amount=" + amount
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Customer)
			{
			Customer other = (Customer) obj;
			return this.email.equals(other.email) && this.password.equals(other.password);
			}
		return false;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public Plan getPlan() {
		return plan;
	}
	
	
	
}
