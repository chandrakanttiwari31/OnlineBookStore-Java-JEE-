package com.bookstore.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.CardDaoImpl;
import com.bookstore.pojo.Cart;

public class CartTest {

	
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		
		 int cartId;
		 int bookId;
	     String bookName;
		 float bookPrice;
		 int quantity;
		 float totalPrice;
	     String emailId;
	     char ch;
	     boolean result;
	     
	     CardDaoImpl cd=new CardDaoImpl();
			Cart c=new Cart();
			
	     
	     do {
	    	 
	     
	   
	     System.out.println("1. Add to Cart");
	     System.out.println("2. update Cart");
	     System.out.println("3. Delete Cart");
	     System.out.println("4. Clear Cart");
	     System.out.println("5. Show My Cart");
	     System.out.println("6. Delete Cart By Book Id");
	     
	     System.out.println("Enter your choice: ");
	     int choice=sc.nextInt();
	     switch(choice)
	     {
	     
	     case 1:
	    	 System.out.println("Add your Details: ");
	    	 System.out.println("Enter your BookId: ");
	    	 c.setBookId(sc.nextInt());
	    	

	    	 System.out.println("Enter your EmailId: ");
	    	 c.setEmailId(sc.next());
	    	 System.out.println("Enter your BookQuantity: ");
	    	 c.setQuantity(sc.nextInt());
	    	 result=cd.addToCart(c);
	    	 if(result)
	    	 {
	    		 System.out.println("Added Successfully");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Try again");
	    	 }
	    	 break;
	    	 
	     case 2:
	    	 System.out.println("Enter the Cartid for update: ");
	    	 c.setCartId(sc.nextInt());
	    	 System.out.println("Enter the book Quantity: ");
	    	 c.setQuantity(sc.nextInt());
	    	 result=cd.updateCart(c);
	    	 if(result)
	    	 {
	    		 System.out.println("Updated Successfully");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Try again");
	    	 }
	    	 
	    	 break;
	    	 
	     case 3:
	    	System.out.println("Enter the CartId for delete: ");
	    	cartId=sc.nextInt();
	    	result=cd.deleteCart(cartId);
	    	if(result)
	    	 {
	    		 System.out.println("Deleted Successfully");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Try again");
	    	 }
	    	 break;
	    	 
	     case 4:
	    	 System.out.println("Enter the EmailId for clear cart: ");
	    	 emailId=sc.next();
	    	 result=cd.clearCart(emailId);
	    	 if(result)
	    	 {
	    		 System.out.println("clear cart Successfully");
	    	 }
	    	 else
	    	 {
	    		 System.out.println("Try again");
	    	 }
	    	 break;
	    	 
	     case 5:
	    	 System.out.println("******Show my Cart********");
	    	 System.out.println("Enter your email Id: ");
	    	 List<Cart> blist=cd.showMyCart(sc.next());
	    	 if(!blist.isEmpty())
	    	 {
	    		 Iterator<Cart>i=blist.iterator();
	    		 while(i.hasNext())
	    		 {
	    			 System.out.println(i.next());
	    		 }
	    		 
	    	 }
	    	 else
	    	 {
	    		 System.out.println("no data found");
	    	 }
	    	 break;
	     case 6:
		    	System.out.println("Enter the book Id for delete: ");
		    	bookId=sc.nextInt();
		    	result=cd.deleteCartByBookId(bookId);
		    	if(result)
		    	 {
		    		 System.out.println("Deleted Successfully");
		    	 }
		    	 else
		    	 {
		    		 System.out.println("Try again");
		    	 }
	    	 default:
	    		System.out.println("Bye bye.....");
	     		
	     }
	     System.out.println("Do you want to continue .......if yes enter y.....:");
         ch=sc.next().charAt(0);
	     }while(ch=='y'||ch=='y');
	     
	}

	
}
