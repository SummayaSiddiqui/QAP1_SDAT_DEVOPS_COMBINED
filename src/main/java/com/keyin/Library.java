package com.keyin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> searchBooks(String query) {
        String lowercaseQuery = query.toLowerCase();
        return books.stream()
                .filter(book -> titleMatches(book, lowercaseQuery) ||
                        authorMatches(book, lowercaseQuery) ||
                        isbnMatches(book, query))
                .collect(Collectors.toList());
    }

    private boolean titleMatches(Book book, String query) {
        return book.getTitle().toLowerCase().contains(query);
    }

    private boolean authorMatches(Book book, String query) {
        return book.getAuthor().toLowerCase().contains(query);
    }

    private boolean isbnMatches(Book book, String query) {
        return book.getIsbn().equalsIgnoreCase(query);
    }
}
