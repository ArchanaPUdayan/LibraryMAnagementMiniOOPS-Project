package com.LibraryManagement.entities;

public class Book {
	private int bookId;
	private String bookTitle;
	private String author;
	private boolean isIssued=false;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isIssued() {
		return isIssued;
	}
	public void setIssued(boolean isIssued) {
		this.isIssued = isIssued;
	}
	public Book(int bookId, String bookTitle, String author, boolean isIssued) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
		this.isIssued = isIssued;
	}
	
	
	public Book(int bookId, String bookTitle, String author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.author = author;
	}
	public Book() {
		super();
	}
	 public void displayBook() {
	        System.out.println("Book ID: " + bookId);
	        System.out.println("Title: " + bookTitle);
	        System.out.println("Author: " + author);
	        System.out.println("-----------------------------");
	    }
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", author=" + author + ", isIssued=" + isIssued
				+ "]";
	}
	
	

}
