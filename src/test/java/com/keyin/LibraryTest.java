package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();

        library.addBook(new Book("1984", "George Orwell", "GO0001"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "HL0001"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "SF0001"));
    }

    @Test
    public void testSearchByTitle() {
        List<Book> result = library.searchBooks("1984");
        Assertions.assertEquals("1984", result.get(0).getTitle());
    }

    @Test
    public void testSearchByAuthor() {
        List<Book> result = library.searchBooks("Harper Lee");
        Assertions.assertEquals(1, result.size(), "Should find one book by author.");
        Assertions.assertEquals("To Kill a Mockingbird", result.get(0).getTitle());
    }

    @Test
    public void testSearchByIsbn() {
        List<Book> result = library.searchBooks("SF0001");
        Assertions.assertEquals(1, result.size(), "Should find one book by Idbn.");
        Assertions.assertEquals("The Great Gatsby", result.get(0).getTitle());
    }

    @Test
    public void testSearchNonExistentBook() {
        List<Book> result = library.searchBooks("Unknown Book");
        Assertions.assertTrue(result.isEmpty(), "Search for a non-existent book should return an empty list.");
    }
}
