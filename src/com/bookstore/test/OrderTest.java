package com.bookstore.test;

import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.CardDaoImpl;
import com.bookstore.dao.OrderDaoImpl;
import com.bookstore.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		
		
		OrderDaoImpl odi=new OrderDaoImpl();
		Order o=new Order();
		
		Scanner sc=new Scanner(System.in);
		boolean flag;
		int choice;
		char ch;
		CardDaoImpl cd=new CardDaoImpl();
		
		do
		{
			   
		     System.out.println("1. place order");
		     System.out.println("2. update order");
		     System.out.println("3. Delete order");
		     System.out.println("4. Clear order");
		     System.out.println("5. Show My order");
		     System.out.println("6. Show All order");
System.out.println("Enter yout choice");
choice=sc.nextInt();
			switch(choice)
			{
			
			case 1:
				
				System.out.println("enter your emailid");
				o.setEmailId(sc.next());
				o=odi.placeOrder(o.getEmailId());
				if(o!=null)
				{
					System.out.println("add successfully");
					cd.clearCart(o.getEmailId());
				}
					else
					System.out.println("not add");
				
				break;
			case 2:
				System.out.println("Enter Order -Id");
				o.setOrderId(sc.nextInt());
				System.out.println("Enter New Status For the  Order");
				o.setStatus(sc.next());
				
				flag=odi.updateOrder(o);
				
			
				if(flag)
					System.out.println("update successfully");
				else
					System.out.println("not  update");
				break;
				
			case 3:
				System.out.println("enter  your order id");
				o.setOrderId(sc.nextInt());
				flag=odi.deleteOrder(o.getOrderId());
				if(flag)
					System.out.println("delete successfully");
				else
					System.out.println("not  not delete");
				break;
			case 4:
				System.out.println("enter email id");
				o.setEmailId(sc.next());
				flag=odi.clearOrder(o.getEmailId());
				if(flag)
					System.out.println("clear successfully");
				else
					System.out.println("not  clear");
				break;
				
			case 5:
				
				System.out.println("enter email-id");
				o.setEmailId(sc.next());
			List<Order> l=	odi.showMyOrder(o.getEmailId());
			if( l !=null && !l.isEmpty())
			{
				
				for(Order oo:l)
				{
					
					System.out.println(oo);
				}
			}
			else
			System.out.println("nno data found");
				break;
				
			case 6:
				System.out.println("show all order");
				List<Order> ll=odi.showAllOrder();
						if( ll !=null && !ll.isEmpty())
						{
							
							for(Order oo:ll)
							{
								
								System.out.println(oo);
							}
						}
						else
						System.out.println("nno data found");
							break;		
			
		 default:
	    		System.out.println("Bye bye.....");
	     		
	     }
	     System.out.println("Do you want to continue .......if yes enter y.....:");
      ch=sc.next().charAt(0);
	     }while(ch=='y'||ch=='y');
	     
	}
}
