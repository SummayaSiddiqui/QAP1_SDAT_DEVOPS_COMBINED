package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String fullName;
    private String userID;
    private List<Book> borrowedBooks;
    private static final int MaxBorrowLimit = 3;

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

    public boolean canBorrow() {
        return borrowedBooks.size() < MaxBorrowLimit;  // Check if the user can borrow more books
    }

    public void borrowBook(Book book) {
        if (canBorrow()) {
            borrowedBooks.add(book);
            book.borrowedBook(this);
        } else {
            throw new IllegalStateException("Borrowing limit exceeded.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnedBook();
        } else {
            throw new IllegalStateException("Book was not borrowed by this user.");
        }
    }

//    Getter for borrowed books
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

}
