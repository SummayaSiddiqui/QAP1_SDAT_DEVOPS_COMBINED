package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {
    private Book book;  // Instance variables
    private User user1;
    private User user2;

    @BeforeEach
    public void setup() {
        book = new Book("1984", "George Orwell", "GO0001");  // Initialize them
        user1 = new User("John Doe", "JD0100");
        user2 = new User("David Sean", "DS0101");
    }

    @Test
    public void testBookAvailability() {
        Assertions.assertTrue(book.isAvailable(), "Any new book added is by default available");

//        Borrowing changes its availability to false
        book.borrowBook(user1);
        Assertions.assertFalse(book.isAvailable(), "Book should be unavailable after borrowing.");

//        Return of a book changes it's status to true
        book.returnBook();
        Assertions.assertTrue(book.isAvailable(), "Book should be available after a return");
    }

    @Test
    //    Took help from AI to resolve the issues in following 2 tests.
    public void anotherUserCannotBorrowAlreadyBorrowedBook() {

        book.borrowBook(user2);
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> book.borrowBook(user2));

        Assertions.assertEquals("Book is already borrowed.", exception.getMessage());
    }

    @Test
    public void unborrowedBookCannotBeReturned() {

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, book::returnBook);
        Assertions.assertEquals("Book was not borrowed.", exception.getMessage());
    }
}
