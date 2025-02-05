package com.keyin;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
//        Book book1 = new Book("1984", "George Orwell", "GO0001");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "HL0001");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "SF0001");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "JA0001");
        Book book5 = new Book("The Catcher in the Rye", "J.D. Salinger", "JS0001");

//        System.out.println(book1.toString());
        System.out.println(book2.toString());
        System.out.println(book3.toString());
        System.out.println(book4.toString());
        System.out.println(book5.toString());

    }
}
