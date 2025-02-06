package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void userCanBorrowWithinLimit() {
        User user = new User("John Doe", "JD0100");

        Book book1 = new Book("1984", "George Orwell", "GO0001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "HL0001");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "SF0001");

        user.borrowBook(book1);
        user.borrowBook(book2);
        user.borrowBook(book3);

        Assertions.assertEquals(3, user.getBorrowedBooks().size(), "User can get maximum 3 books issued.");
    }
    @Test
    public void userCannotBorrowBeyondLimit() {
        User user = new User("John Doe", "JD0100");

        Book book1 = new Book("1984", "George Orwell", "GO0001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "HL0001");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "SF0001");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "JA0001");

        user.borrowBook(book1);
        user.borrowBook(book2);
        user.borrowBook(book3);

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> user.borrowBook(book4) );
        Assertions.assertEquals("Borrowing limit exceeded.", exception.getMessage());
    }

    @Test
    public void userCanReturnBook() {
        User user = new User("John Doe", "JD0100");
        Book book1 = new Book("1984", "George Orwell", "GO0001");

//      User borrows a book
        user.borrowBook(book1);
        Assertions.assertEquals(1, user.getBorrowedBooks().size(), "User should have borrowed 1 book.");

//      User returns the book
        user.returnBook(book1);
        Assertions.assertEquals(0, user.getBorrowedBooks().size(), "User should have 0 books after returning.");
    }

    @Test
    public void userCannotBorrowSameBookTwice() {
        User user = new User("John Doe", "JD0100");
        Book book = new Book("1984", "George Orwell", "GO0001");

        user.borrowBook(book);

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> user.borrowBook(book));
        Assertions.assertEquals("User already borrowed this book.", exception.getMessage());
    }

    @Test
    public void userCannotReturnUnborrowedBook() {
        User user = new User("John Doe", "JD0100");
        Book book = new Book("1984", "George Orwell", "GO0001");

        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> user.returnBook(book));
        Assertions.assertEquals("User did not borrow this book.", exception.getMessage());
    }

}
