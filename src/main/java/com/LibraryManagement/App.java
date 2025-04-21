package com.LibraryManagement;

import java.sql.SQLException;
import java.util.Scanner;

import com.LibraryManagement.entities.Book;
import com.LibraryManagement.entities.Library;
import com.LibraryManagement.entities.Member;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException
    {
    	Scanner sc=new Scanner(System.in);
		Library library=new Library();
		
		int choice;
		do {
			System.out.println("***************Library Management System*******************");
			System.out.println("1.Add Book");
			System.out.println("2.View all Books");
			System.out.println("3.Register Member");
			System.out.println("4.Issue Book");
			System.out.println("5.View Borrowed Books");
			System.out.println("6.Exit");
			System.out.println("7.Enter your choice");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter the Book Id : ");
				int bookId=sc.nextInt();
				System.out.println("Enter Book Title : ");
				String  bookTitle=sc.next();
				System.out.println("Enter Book author : ");
				String author=sc.next();
				library.addBooks(new Book(bookId,bookTitle,author));
				break;
				
			case 2:
				System.out.println("View all Books");
				library.viewAllBooks();
				break;
				
			case 3:
				System.out.println("Enter the memberId : ");
				int memberId=sc.nextInt();
				System.out.println("Enter the memberName : ");
				String memberName=sc.next();
				library.registerMember(new Member(memberId,memberName));
				break;
				
			case 4:
				System.out.println("Enter Book Id to Issue : ");
				int issueBookId=sc.nextInt();
				System.out.println("Enter Member id : ");
				int Id=sc.nextInt();
				library.issueBook(issueBookId, Id);
				break;
				
			case 5:
				System.out.println("Enter member Id to view borrowed book : ");
				int memberid=sc.nextInt();
				Member member=library.viewBorrowedBooks(memberid);
				if(member!=null) {
					member.viewBorrowedBooks();
				}else {
					System.out.println("Member not found...");
				}
				break;
				
			
			case 6:
				System.out.println("Exiting the library system ,Good Bye...");
				break;
				
				default:
					System.out.println("Invalid choice,pls check again...");
			
				
			}
		
			
		}
		while(choice!=6);
			sc.close();
		
		
	}
    }

