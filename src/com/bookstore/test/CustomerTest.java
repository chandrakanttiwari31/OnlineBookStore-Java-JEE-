package com.bookstore.test;

import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.CustomerDaoImpl;
import com.bookstore.pojo.Customer;

public class CustomerTest {

	public static void main(String[] args) {

		String emailId;
		String name;
		long contactNumber;
		String address;
		String password;

		Customer c = new Customer();
		CustomerDaoImpl cdi = new CustomerDaoImpl();

		boolean result;

		Scanner sc = new Scanner(System.in);

		int choice;
		char ch;

		do {

			System.out.println("********************Book Store Management*****************");
			System.out.println("=================================================");
			System.out.println(" 1. Add Customer");
			System.out.println(" 2. Update Customer ");
			System.out.println(" 3. Delete Customer");
			System.out.println(" 4. Show Customer List");
			System.out.println(" 5. Search Customer By Email-Id");
			System.out.println("===================================================");
			System.out.println("\n Enter Your Choice");

			choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("**********Adding customer process");
				System.out.println("-------------------------------");

//				 
				System.out.println("Enter Customer Email-Id");
				c.setEmailId(sc.next());
				System.out.println("Enter Customer Name");
				c.setName(sc.next());
				System.out.println("Enter Customer Contact ");
				c.setContactNumber(sc.nextLong());

				System.out.println("Enter Customer Address");
				c.setAddress(sc.next());
				System.out.println("Enter Customer Password");
				c.setPassword(sc.next());

				result = cdi.addCustomer(c);
				if (result)
					System.out.println("Successfully Added");
				else
					System.out.println("Not  Added");

				break;

			case 2:

				System.out.println("**********Updating customer process");
				System.out.println("-------------------------------");

				System.out.println("Enter  Existing Customer Id Which You Want To  Update");
				c.setEmailId(sc.next());

				System.out.println("Enter Customer Name");
				c.setName(sc.next());
				System.out.println("Enter Customer Contact ");
				c.setContactNumber(sc.nextLong());

				System.out.println("Enter Customer Address");
				c.setAddress(sc.next());
				System.out.println("Enter Customer Password");
				c.setPassword(sc.next());

				result = cdi.updateCustomer(c);
				if (result)
					System.out.println("Successfully Update");
				else
					System.out.println("Not  Update");

				break;

			case 3:
				System.out.println("**********deleting operation*********");
				System.out.println("--------------------------------------");
				System.out.println("Enter  Customer Email_Id which You Want To Delete Record");

				result = cdi.deleteCustomer(sc.next());

				if (result)
					System.out.println("delete  Customer successfully");
				else
					System.out.println("Customer not deleted");

				break;

			case 4:

				System.out.println("***************Customer  List************");
				System.out.println("=====================================");

				List<Customer> custlist = cdi.showAllCustomer();
				if (!custlist.isEmpty()) {
					for (Customer cc : custlist) {

						System.out.println(cc);
					}

				} else {

					System.out.println("  List is Empty");
				}

				break;

			case 5:

				System.out.println("**********Searching  Customer By Email In Record");
				System.out.println("-------------------------------");

				System.out.println("Enter Customer Email");
				c = cdi.searchCustomer(sc.next());
				//System.out.println(c);
				if (c != null)
					System.out.println(c);
				else
					System.out.println("No Data Found");
				break;
				
			default:
				System.out.println("Operations Done");
			}
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}
}
