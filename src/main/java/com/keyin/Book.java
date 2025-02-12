package com.keyin;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private User borrowedBy;

    //    Constructor
    public Book (String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.borrowedBy = null;
    }

    //    Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }

//    Borrowing logic
    public void borrowBook(User user) {
        if (isAvailable) {
            isAvailable = false;
            this.borrowedBy = user;
        } else {
            throw new IllegalStateException("Book is already borrowed.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            this.borrowedBy = null;
        } else {
            throw new IllegalStateException("Book was not borrowed.");
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", available=" + isAvailable +
                ", borrowed by=" + (borrowedBy != null ? borrowedBy.getName() : "None") +
                '}';
    }
}
