package com.bookstore.test;

import java.util.List;
import java.util.Scanner;

import com.bookstore.dao.BookDaoImpl;
import com.bookstore.pojo.Book;

public class BookTest {

	public static void main(String[] args) {

		int choice;
		char ch;
		boolean result;
		Scanner sc = new Scanner(System.in);

		int bookId;
		String bookName;
		String bookAuthorName;
		long price;
		String bookPublication;
		String bookCategory;
		String language;

		Book b1 = new Book();

		BookDaoImpl bdi = new BookDaoImpl();
		do {
			System.out.println("********************Book Store Management*****************");
			System.out.println("=================================================");
			System.out.println(" 1. Add Book");
			System.out.println(" 2. Update Book ");
			System.out.println(" 3. Delete Book");
			System.out.println(" 4. Show Book List");
			System.out.println(" 5. Search Book By Book Name");
			System.out.println(" 6. Search Book By Author Name");
			System.out.println(" 7. Search Book By Book Id");
			System.out.println(" 8. Search Book  By Book Category");
			System.out.println("===================================================");
			System.out.println("\n Enter Your Choice");

			choice = sc.nextInt();
			switch (choice) {

			case 1:
				System.out.println("**********Adding Book process");
				System.out.println("-------------------------------");

				System.out.println("Enter Book Name");
				b1.setBookName(sc.next());
				System.out.println("Enter Book Author Name");
				b1.setBookAuthorName(sc.next());
				System.out.println("Enter Book Price");
				b1.setPrice(sc.nextLong());
				System.out.println("Enter Book Publication");
				b1.setBookPublication(sc.next());
				System.out.println("Enter Book Category");
				b1.setBookCategory(sc.next());
				System.out.println("Enter Book Language");
				b1.setLanguage(sc.next());

				result = bdi.addBook(b1);

				if (result)
					System.out.println("Book Added Successfully");
				else
					System.out.println("Book not Added");
				break;
				
			case   2:
				System.out.println("**********Updating Book process");
				System.out.println("-------------------------------");
				System.out.println("Enter  Existing Book Id Which You Want To  Update");
				b1.setBookId(sc.nextInt());
				System.out.println("Enter Book Name");
				b1.setBookName(sc.next());
				System.out.println("Enter Book Author Name");
				b1.setBookAuthorName(sc.next());
				System.out.println("Enter Book Price");
				b1.setPrice(sc.nextLong());
				System.out.println("Enter Book Publication");
				b1.setBookPublication(sc.next());
				System.out.println("Enter Book Category");
				b1.setBookCategory(sc.next());
				System.out.println("Enter Book Language");
				b1.setLanguage(sc.next());

			result=bdi.updateBook(b1);
			if (result)
				System.out.println("Book Update Successfully");
			else
				System.out.println("Book not Update");
			break;
			

			case 3:
				System.out.println("**********Delete Book List");
				System.out.println("-------------------------------");
				System.out.println("Enter Book Id  Which You Want To Delete");
				result = bdi.deleteBook(sc.nextInt());

				if (result)
					System.out.println("Delete Successfully");
				else
					System.out.println("not delete");
				break;
			case 4:
				System.out.println("**********Show Book List");
				System.out.println("-------------------------------");

				List<Book> l = bdi.showAllBook();
				if (!l.isEmpty()) {

					for (Book book : l) {

						System.out.println(book);
					}
				} else
					System.out.println(" Book List Is empty");
				break;

			case 5:

				System.out.println("**********Search Book By Book Name********");
				System.out.println("-------------------------------------------");

				System.out.println("Enter Book Name Which You Want to Search");

				List<Book> l1 = bdi.searchBookByName(sc.next());

				if (l1 != null) {

					System.out.println(l1);
				} else
					System.out.println("Book Not Available For This Boook Name");
				break;

			case 6:

				System.out.println("**********Search Book By Book Author Name********");
				System.out.println("-------------------------------------------");
				List<Book> booklist = bdi.searchBookByAuthor(sc.next());
				if (booklist != null) {

					System.out.println(booklist);
				} else
					System.out.println("Book Not Available For This Boook Name");
				break;

			case 7:

				System.out.println("**********Search Book By Book Id********");
				System.out.println("-------------------------------------------");
				System.out.println("Enter Book Id  Which You Want To Search");
				b1 = bdi.searchBookById(sc.nextInt());
				if (b1 != null)
					System.out.println(b1);
				else
					System.out.println("Record Is not Available For This Book Id");
				break;

			case 8:

				System.out.println("**********Search Book By Book Category********");
				System.out.println("-------------------------------------------");
				System.out.println("Enter Book Category  Which You Want To Search");
				List<Book> bb = bdi.searchBookByCategory(sc.next());
				if (bb != null)
					System.out.println(bb);
				else
					System.out.println("Record Is not  Available");
				break;

			default:
				System.out.println("Operations Done");
			}
			System.out.println("Do You Eant To Continue...If Yes Enter Y....:");
			ch = sc.next().charAt(0);
		} while (ch == 'y' || ch == 'Y');

	}
}
