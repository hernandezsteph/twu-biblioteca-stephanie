package com.twu.biblioteca;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Book {
    private String title;
    private String author;
    private int year;
    private int id;
    private boolean isCheckedOut;

    public Book(String title, String author, int year,int id) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.id = id;
        isCheckedOut = false;
    }

    public int getId() {
        return id;
    }

    public void checkedOut(){
        isCheckedOut = true;
    }

    public void returnBook() { isCheckedOut = false; }

    public boolean isCheckedOut(){
        return isCheckedOut;
    }

    public String formatWithID(){
        return String.format("|| %-15s || %-15s || %-5s || %-1s", title, author, Integer.toString(year), Integer.toString(id));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year &&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return String.join(", ", title, author, Integer.toString(year));
    }

}
