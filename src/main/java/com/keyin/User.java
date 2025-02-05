package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String fullName;
    private String userID;
    private List<Book> borrowedBooks;
    private int MaxBorrowLimit = 3;

    public User(String fullName, String userID) {
        this.fullName = fullName;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }

//    Getter
    public String getName() {
        return this.fullName;
    }

    public String getUserId() {
        return this.userID;
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() >= MaxBorrowLimit) {
            throw new IllegalStateException("User has already borrowed the maximum number of books.");
        }
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.borrowedBook();
        } else {
            throw new IllegalStateException("This book is already borrowed.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnedBook();
        } else {
            throw new IllegalStateException("This book is already borrowed.");
        }
    }

//    Getter for borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
