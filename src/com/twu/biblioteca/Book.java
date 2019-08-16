package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String formatString(){
        return String.format("|| %-15s || %-15s || %-1s", title, author, Integer.toString(year));

    }

    @Override
    public String toString() {
        return String.join(", ", title, author, Integer.toString(year));
    }

}
