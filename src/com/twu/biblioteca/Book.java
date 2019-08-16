package com.twu.biblioteca;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;
    private int id;
    private boolean isCheckedOut;

    public Book(String title, String author, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
        this.id = 1; //TODO: SET RANDOM
        isCheckedOut = false;
    }

    public void checkedOut(){
        isCheckedOut = true;
    }

    public boolean isCheckedOut(){
        return isCheckedOut;
    }

    public String formatString(){
        return String.format("|| %-15s || %-15s || %-1s", title, author, Integer.toString(year));
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

    // TODO: replace format string to include id, why not always show id?
    public String formatWithID(){
        return String.format("|| %-15s || %-15s || %-10s || %-1s", title, author, Integer.toString(year), Integer.toString(id));
    }

    @Override
    public String toString() {
        return String.join(", ", title, author, Integer.toString(year));
    }

}
