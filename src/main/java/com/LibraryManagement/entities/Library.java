package com.LibraryManagement.entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Library {
//	private List<Book>books=new ArrayList<>();
//	private List<Member> members=new ArrayList<>();
//	
//	public void addBooks(Book book) {
//		books.add(book);
//		System.out.println("Book Added : "+book.getBookTitle());
//		
//	}
	
	public void addBooks(Book book) throws SQLException {
		try(Connection conn=DBConnection.getConnection()){
			String query="insert into book(bookId,bookTitle,author,isIssued) values(?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, book.getBookId());
			stmt.setString(2, book.getBookTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setBoolean(4, false);  //book not issued by default
			stmt.executeUpdate();
			System.out.println("Book inserted to database : "+book.getBookId());
			
		}
	}
	
//	public void viewAllBooks() {
//		if(books.isEmpty()) {
//			System.out.println("No books in the Library yet...");
//		}else {
//			for(Book book:books) {
//				book.displayBook();
//			}
//		}
//	}
	
	public void viewAllBooks() {
		try(Connection conn=DBConnection.getConnection()){
			String query="select * from book";
			Statement stmt=conn.createStatement();
			ResultSet  rs=stmt.executeQuery(query); //select
			while(rs.next()) {
				Book book=new Book(
					rs.getInt("bookId"),
					rs.getString("bookTitle"),
					rs.getString("author"),
					rs.getBoolean("isIssued"));
				book.displayBook();
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	public void registerMember(Member member) {
//		members.add(member);
//		System.out.println("Member Registered :"+member.getName());
//		
//	}
	
	public void registerMember(Member member) throws SQLException {
		try(Connection conn=DBConnection.getConnection()){
			String query="insert into member(memberId,name) values(?,?)";
			PreparedStatement stmt=conn.prepareStatement(query);
			stmt.setInt(1, member.getMemberId());
			stmt.setString(2, member.getName());
			stmt.executeUpdate();
			System.out.println("Member inserted to database successfully..."+member.getMemberId());
		}
		
	}
	
	
//	public Book findBookById(int id) {
//		for(Book book:books) {
//			if(book.getBookId()==id&&!book.isIssued()) {
//				return book;
//			}
//		}
//		return null;
//	}
//	
//	public Member findMemberById(int id) {
//		for(Member member:members) {
//			if(member.getMemberId()==id) {
//				return member;
//			}
//		}
//		return null;
//		
//	}
	
//	public void issueBook(int bookId,int memberId) {
//		Book book=findBookById(bookId);
//		Member member=findMemberById(memberId);
//		if(book!=null &&member!=null) {
//			member.borrowBooks(book);
//			
//		}else {
//			System.out.println("Either the book is not available or member not exist...");
//		}
//	}
	
	public void issueBook(int bookId,int memberId) throws SQLException {
		try(Connection conn=DBConnection.getConnection()){
		String query="select * from book where bookId=? and isIssued=false";
		
		PreparedStatement ps=conn.prepareStatement(query);
		ps.setInt(1, bookId);
		
		ResultSet  rs=ps.executeQuery();
		if(rs.next()) {
			String updateQuery="update book set isIssued=true where bookId=?";
			PreparedStatement  ps1=conn.prepareStatement(updateQuery);
			ps1.setInt(1, bookId);
			ps1.executeUpdate();
			
			String insertBorrow="insert into borrow(memberId,bookId)values(?,?)";
			PreparedStatement ps2=conn.prepareStatement(insertBorrow);
			ps2.setInt(1, memberId);
			ps2.setInt(2, bookId);
			ps2.executeUpdate();
			System.out.println("Book issued successfully to memberId"+memberId);
			
			
		}else {
			System.out.println("Book not available or already issued.....");
		}
			
		}
	}
	//view books borrowed by a specific person
	public Member viewBorrowedBooks(int memberId) throws SQLException {
	    String query = "SELECT m.name, b.bookTitle FROM member m " +
	                   "JOIN borrow br ON m.memberId = br.memberId " +
	                   "JOIN book b ON br.bookId = b.bookId WHERE m.memberId = ?";

	    Member member = new Member();
	    member.setMemberId(memberId);

	    try (Connection conn = DBConnection.getConnection()) {
	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setInt(1, memberId);
	        ResultSet rs = ps.executeQuery();

	        boolean hasBooks = false;

	        while (rs.next()) {
	            hasBooks = true;

	            // Set member name from result
	            if (member.getName() == null) {
	                member.setName(rs.getString("name"));  // fixed this line
	                System.out.println("Books borrowed by " + member.getName());
	            }

	            String title = rs.getString("bookTitle");
	            System.out.println("Title: " + title);

	            Book book = new Book();
	            book.setBookTitle(title);
	            member.getBorrowedBooks().add(book);
	        }

	        if (!hasBooks) {
	            System.out.println("No books currently borrowed by this member.");
	        }
	    }

	    return member;
	}


}
