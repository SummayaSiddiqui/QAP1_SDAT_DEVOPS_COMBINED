package com.keyin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final String fullName;
    private final String userID;
    private final List<Book> borrowedBooks;
    private static final int MAX_BORROW_LIMIT = 3;

    public User(String fullName, String userID) {
        this.fullName = fullName;
        this.userID = userID;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return fullName;
    }

    public String getUserId() {
        return userID;
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < MAX_BORROW_LIMIT;
    }

    public void borrowBook(Book book) {
        if (!canBorrow()) {
            throw new IllegalStateException("Borrowing limit exceeded.");
        }
        if (borrowedBooks.contains(book)) {
            throw new IllegalStateException("Book is already borrowed by this user.");
        }
        borrowedBooks.add(book);
        book.borrowBook(this);
    }

    public void returnBook(Book book) {
        if (!borrowedBooks.contains(book)) {
            throw new IllegalStateException("Book was not borrowed by this user.");
        }
        borrowedBooks.remove(book);
        book.returnBook();
    }

    public List<Book> getBorrowedBooks() {
        return Collections.unmodifiableList(borrowedBooks); // Prevent external modification
    }
}
