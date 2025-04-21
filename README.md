# LibraryMAnagementMiniOOPS-Project
Mini Java Console Library Management System using JDBC and MySQL
# Mini Java Console Library Management System using JDBC and MySQL 📚

This is a mini console-based library management system built in **Java** using **JDBC** for database connectivity with **MySQL**. The system allows administrators to manage books and members, as well as issue books to members.

## Features
- **Add Book**: Add new books to the library.
- **View All Books**: View all available books in the library.
- **Register Member**: Register a new member to the library.
- **Issue Book**: Issue a book to a member.
- **View Borrowed Books**: View all the books borrowed by a specific member.

## Technologies Used
- **Java**: Core Java (8+), JDBC
- **MySQL**: Database for storing books, members, and borrowing details
- **IDE**: IntelliJ IDEA or Eclipse

## Database Schema

1. **Book Table**
   - `bookId` (int, Primary Key)
   - `bookTitle` (varchar)
   - `author` (varchar)
   - `isIssued` (boolean)

2. **Member Table**
   - `memberId` (int, Primary Key)
   - `name` (varchar)

3. **Borrow Table**
   - `memberId` (int, Foreign Key)
   - `bookId` (int, Foreign Key)
