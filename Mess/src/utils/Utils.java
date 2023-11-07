package utils;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.app.core.Customer;
import com.app.core.Plan;
import com.app.exeption.CustomException;

public class Utils {
	
	public static Customer authenticate(String email, String password,Map<String, Customer> map) throws CustomException
	{
		Customer refCustomer=new Customer(email,password);
		if(map.containsKey(email))
			if(map.containsValue(refCustomer))
				{
				System.out.println("Signed in");
				return refCustomer;
				}
			else
				throw new CustomException("Invalid password");
		else 
			throw new CustomException("Invalid email");
	}
	
	public static void changepassword(String email, String password,Map<String, Customer> map,Scanner sc) throws CustomException
	{
		authenticate(email,password,map);
		map.get(email).setPassword(sc.next());
	}
	
	public static void sorting(Map<String, Customer> map,Scanner sc)
	{
		System.out.println("\n1.First Name \n2.Plan \n3.Date of registration");
		System.out.println("Enter choice");
		switch(sc.nextInt())
		{
		case 1:
			Comparator<Customer> comp1=(c1,c2)->{ return c1.getFirstName().compareTo(c2.getFirstName());};
			map.values().stream().sorted(comp1).forEach(System.out::println);
			break;
		case 2:
			Comparator<Customer> comp2=(c1,c2)->{return c1.getPlan().compareTo(c2.getPlan());};
			map.values().stream().sorted(comp2).forEach(System.out::println);
			break;
		case 3:
			Comparator<Customer> comp3=(c1,c2)->{return c1.getRegisterDate().compareTo(c2.getRegisterDate());};
			map.values().stream().sorted(comp3).forEach(System.out::println);
			break;
		}
	}
	
	public static void displayall(Map<String, Customer> map)
	{
		map.values().stream().forEach(System.out::println);
	}
	
	public static void modifyname(Map<String, Customer> map)
	{
		List<Customer> list=map.values().stream().collect(Collectors.toList());
		for(Customer c: list)
		{
			String f=c.getFirstName().substring(0, 1);
			String s=f.toUpperCase()+c.getFirstName().substring(1);
			c.setFirstName(s);
		}
		list.stream().forEach(System.out::println);
	}
	
	public static void monthlycustomers(int month, Map<String, Customer> map)
	{
		map.values().stream().filter(s->s.getRegisterDate().getMonth().equals(Month.of(month))).forEach(System.out::println);
	}
	
	public static void customersPerPlan(Map<String, Customer> map)
	{
		for(Plan p: Plan.values())
			System.out.println("Count of "+p+":"+map.values().stream().filter(s->s.getPlan().equals(p)).count());
	}
	
	public static void searchByCity(String city,Map<String, Customer> map)
	{
		map.values().stream().filter(s->s.getAddress().equals(city)).forEach(System.out::println);
	}
	
	public static void applyDiscount(Map<String, Customer> map)
	{
		List<Customer> list=map.values().stream().collect(Collectors.toList());
		for(Customer c: list)
		{
			if(c.getPlan().equals(Plan.YEARLY))
				{
				double amt=c.getPlan().getAmount()*0.20;
				c.getPlan().setAmount(amt);
				System.out.println("Discounted price"+c.getPlan().getAmount());
				}
		}
	}
}
