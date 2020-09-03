package com.bookstore.test;

import java.util.Scanner;

import com.bookstore.dao.LoginDaoImpl;

public class LoginTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int choice;
		char ch;
		boolean result;

		LoginDaoImpl ld = new LoginDaoImpl();

		String name, pass;

		do {
			System.out.println("********************Book Store Management*****************");
			System.out.println("=================================================");
			System.out.println(" 1. Login As Customer");
			System.out.println(" 2. Login As Admin");
			System.out.println(" 3. Change password of Customer");
			System.out.println(" 4. Change password of Admin");

			System.out.println("\n Enter Your Choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter Yourr Email-id");
				name = sc.next();

				System.out.println("Enter your Password ");
				pass = sc.next();
				result = ld.customerLogin(name, pass);

				if (result)
					System.out.println("Login Successfully");
				else
					System.out.println("Try Again.....");
				break;

			case 2:

				System.out.println("Enter UserName");
				name = sc.next();

				System.out.println("Enter your Password ");
				pass = sc.next();
				result = ld.adminLogin(name, pass);

				if (result)
					System.out.println("Login Successfully");
				else
					System.out.println("Try Again.....");
				break;

			case 3:

				System.out.println("Enter Your existing Email-id");
				name = sc.next();

				System.out.println("Enter your new Password ");
				pass = sc.next();
				result = ld.changeCustomerPassword(name, pass);

				if (result)
					System.out.println("Update Successfully");
				else
					System.out.println("Try Again.....");
				break;

			case 4:

				System.out.println("Enter Your Existing Username");
				name = sc.next();

				System.out.println("Enter your new Password ");
				pass = sc.next();
				result = ld.changeAdminPassword(name, pass);

				if (result)
					System.out.println("Update Successfully");
				else
					System.out.println("Try Again.....");
				break;
			default:
				System.out.println("Operations Done");
			}
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}
}
