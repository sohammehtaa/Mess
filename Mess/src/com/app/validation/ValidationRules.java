package com.app.validation;

import java.util.Map;

import com.app.core.Customer;
import com.app.core.Plan;
import com.app.exeption.CustomException;

public class ValidationRules {

	public static void checkDuplicate(String email,Map<String,Customer> map) throws CustomException
	{
		if(map.containsKey(email))
			throw new CustomException ("This email already exists");	
	}
	
	public static Plan parseAndValidate(String plan,double amount) throws CustomException
	{
		Plan messplan=Plan.valueOf(plan.toUpperCase());
		if(messplan.getAmount()!=amount)
			throw new CustomException("Invalid plan amount");
		return messplan;
	}
	
	public static void validateNumber(String phoneNo) throws CustomException
	{
		String pattern="^[0-9]{10}$";
		if(!phoneNo.matches(pattern))
			throw new CustomException("Invalid phone number");
	}
	
	public static Customer validateall(String firstName, String lastName, String email, String password, String address, String phoneNo, String plan, double amount, Map<String,Customer> map) throws CustomException
	{
		checkDuplicate(email,map);
		Plan xplan=parseAndValidate(plan,amount);
		validateNumber(phoneNo);
		
		return new Customer(firstName, lastName, email, password, address, phoneNo, xplan, amount);
	}
}
