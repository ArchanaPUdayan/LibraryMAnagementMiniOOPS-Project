package com.LibraryManagement.entities;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private int memberId;
	private String name;
	private List<Book> borrowedBooks=new ArrayList<>();
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	public Member(int memberId, String name, List<Book> borrowedBooks) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.borrowedBooks = borrowedBooks;
	}
	
	
	public Member(int memberId, String name) {
		super();
		this.memberId = memberId;
		this.name = name;
	}
	
	
	public Member() {
		super();
	}
	//borrow book
	public void borrowBooks(Book book) {
		borrowedBooks.add(book);
		book.setIssued(true);
		System.out.println(name+"borrowed"+book.getBookTitle());
	}
	//view borrow books
	public void viewBorrowedBooks() {
		if(borrowedBooks.isEmpty()) {
			System.out.println(name+"has not borrowed any books :");
			
		}else {
			System.out.println("Books borrowed by "+name);
			for(Book books:borrowedBooks) {
				System.out.println("--"+books.getBookTitle());
				
			}
		}
	}

}
