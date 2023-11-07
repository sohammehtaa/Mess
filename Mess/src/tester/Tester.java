package tester;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Customer;

import static com.app.validation.ValidationRules.*;
import static utils.Utils.*;
import static utils.CustomerUtils.populateMess;
import static utils.IOUtils.*;

public class Tester {

	public static void main(String[] args)  {
		try(Scanner sc = new Scanner(System.in))
		{
			Map<String, Customer> map = populateMess();
			try 
			{
				System.out.println("--------------> Welcome to sk mess service <------------");
			
				System.out.println("\n1.Sign up \n2. Sign in \n3. Chane Password \n4. Sort Customer \n5. Unsubscribe customer "
						+ "\n6. Display all Customers \n7. Modify Names \n8. Display monthly customers "
						+ "\n9. Display customers count as per plan \n10. Search customers by location \n11. Special Discount \n12. Restore details");
				
				boolean exit=false;
				while(!exit)
				{
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("---> Sign up <---");
						System.out.println("enter your details: ");
						System.out.println("firstName, lastName, email, password, address, phoneNo, plan, amount");
						Customer newCustomer=(validateall(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),sc.nextDouble(),map));
						map.put(newCustomer.getEmail(), newCustomer);
						System.out.println("Customer added to mess.");
						break;
						
					case 2:
						System.out.println("---> Sign in <---");
						System.out.println("enter your details: ");
						authenticate(sc.next(),sc.next(),map);
						break;
						
					case 3:
						System.out.println("---> Change Password <---");
						System.out.println("enter your details: ");
						changepassword(sc.next(),sc.next(),map,sc);
						System.out.println("password changed");
						break;
						
					case 4:
						System.out.println("---> Sort Customer <---");
						sorting(map,sc);
						break;
						
					case 5:
						System.out.println("---> Unsubscribe customer <---");
						System.out.println("enter your details: ");
						Customer ref=authenticate(sc.next(),sc.next(),map);
						map.remove(ref.getEmail());
						System.out.println("Unsubscribed mess");
						break;
						
					case 6:
						System.out.println("---> Display all <---");
						displayall(map);
						break;
						
					case 7:
						System.out.println("---> Modify Names <---");
						modifyname(map);
						break;
						
					case 8:
						System.out.println("---> Display monthly customers <---");
						System.out.println("enter the month");
						monthlycustomers(sc.nextInt(),map);
						break;
					
					case 9:
						System.out.println("---> Display customers count as per plan <---");
						System.out.println("Enter the plan");
						customersPerPlan(map);
						break;
						
					case 10:
						System.out.println("---> Search customers by location <---");
						System.out.println("enter the city");
						searchByCity(sc.next(),map);
						break;
						
					case 11:
						System.out.println("---> Discount <---");
						applyDiscount(map);
						break;
						
					case 12:
						System.out.println("---> Restoring Mess Status <---");
						restoreDetails(map,"soham");
						break;
						
					default:
						System.out.println("---> Store Updated Mess Status <---");
						System.out.println("Enter file name");
						storeDetails(map,sc.next());
						System.out.println("---> Exit <---");
						break;
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace(); 
			}
		}
	}

}
