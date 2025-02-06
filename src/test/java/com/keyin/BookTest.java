package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookTest {
    @Test
    public void testBookAvailability() {
        Book book = new Book("1984", "George Orwell", "GO0001");
        User user = new User("John Doe", "JD0100");
//        Any new book is available by default
        Assertions.assertTrue(book.isAvailable(), "Any new book added is by default available");

//        Borrowing changes its availability to false
        book.borrowedBook(user);
        Assertions.assertFalse(book.isAvailable(), "Book should be unavailable after borrowing.");

//        Return of a book changes it's status to true
        book.returnedBook();
        Assertions.assertTrue(book.isAvailable(), "Book should be available after a return");
    }

    @Test
    //    Took help from AI to resolve the issues in following 2 tests.
    public void AnotherUserCannotBorrowAlreadyBorrowedBook() {
        Book book = new Book("1984", "George Orwell", "GO0001");
        User user1 = new User("John Doe", "JD0100");
        User user2 = new User("David Sean", "DS0101");

        book.borrowedBook(user1);
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> book.borrowedBook(user2));

        Assertions.assertEquals("Book is already borrowed.", exception.getMessage());
    }

    @Test
    public void UnborrowedBookCannotBeReturned() {
        Book book = new Book("1984", "George Orwell", "GO0001");

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, book::returnedBook);
        Assertions.assertEquals("Book was not borrowed.", exception.getMessage());
    }
}
