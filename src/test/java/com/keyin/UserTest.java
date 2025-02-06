package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {
    private User user;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;

    @BeforeEach
    void setUp() {
        user = new User("John Doe", "JD0100");
        book1 = new Book("1984", "George Orwell", "GO0001");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee", "HL0001");
        book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "SF0001");
        book4 = new Book("Pride and Prejudice", "Jane Austen", "JA0001");
    }

    @Test
    void userCanBorrowWithinLimit() {
        user.borrowBook(book1);
        user.borrowBook(book2);
        user.borrowBook(book3);

        Assertions.assertEquals(3, user.getBorrowedBooks().size(), "User should be able to borrow up to 3 books.");
    }

    @Test
    void userCannotBorrowBeyondLimit() {
        user.borrowBook(book1);
        user.borrowBook(book2);
        user.borrowBook(book3);

        IllegalStateException exception = Assertions.assertThrows(
                IllegalStateException.class,
                () -> user.borrowBook(book4),
                "Expected exception when borrowing beyond limit."
        );
        Assertions.assertEquals("Borrowing limit exceeded.", exception.getMessage());
    }

    @Test
    void userCanReturnBook() {
        user.borrowBook(book1);
        Assertions.assertEquals(1, user.getBorrowedBooks().size(), "User should have 1 borrowed book.");

        user.returnBook(book1);
        Assertions.assertEquals(0, user.getBorrowedBooks().size(), "User should have 0 books after returning.");
    }

    @Test
    void userCannotBorrowSameBookTwice() {
        user.borrowBook(book1);

        IllegalStateException exception = Assertions.assertThrows(
                IllegalStateException.class,
                () -> user.borrowBook(book1),
                "Expected exception when borrowing the same book twice."
        );
        Assertions.assertEquals("Book is already borrowed by this user.", exception.getMessage());
    }

    @Test
    void userCannotReturnUnborrowedBook() {
        IllegalStateException exception = Assertions.assertThrows(
                IllegalStateException.class,
                () -> user.returnBook(book1),
                "Expected exception when returning a book not borrowed."
        );
        Assertions.assertEquals("Book was not borrowed by this user.", exception.getMessage());
    }
}
