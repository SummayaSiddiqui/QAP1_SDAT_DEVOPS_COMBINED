package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBooks(String query) {
        List<Book> results = new ArrayList<>();
        String lowercaseQuery = query.toLowerCase();

        for (Book book : books) {
            if (matchesTitle(book, lowercaseQuery) ||
                    matchesAuthor(book, lowercaseQuery) ||
                    matchesIsbn(book, query)) {
                results.add(book);
            }
        }

        return results;
    }

    private boolean matchesTitle (Book book, String lowercaseQuery){
        return book.getTitle().toLowerCase().contains(lowercaseQuery);
    }

    private boolean matchesAuthor (Book book, String lowercaseQuery){
        return book.getAuthor().toLowerCase().contains(lowercaseQuery);
    }

    private boolean matchesIsbn (Book book, String query){
        return book.getIsbn().equalsIgnoreCase(query);
    }
}

