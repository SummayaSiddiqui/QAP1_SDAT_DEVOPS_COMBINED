package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void testBookAvailability() {
        Book book = new Book("1984", "George Orwell", "GO0001");

//        Any new book is available by default
        Assertions.assertTrue(book.isAvailable(), "Any new book added is by default available");

//        Borrowing changes its availability to false
        book.borrowBook();
        Assertions.assertFalse(book.isAvailable(), "Book should be unavailable after borrowing.");

//        Return of a book changes it's status to true
        book.returnBook();
        Assertions.assertTrue(book.isAvailable(), "Book should be available after a return");
    }
}
