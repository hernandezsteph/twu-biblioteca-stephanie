package com.twu.biblioteca;

import java.io.*;
import java.util.*;

public class BibliotecaApp {

    private PrintStream printStream;
    private List<Book> books;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
        books = new ArrayList<>();
    }

    public void startBiblioteca(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        ViewBiblioteca view = new ViewBiblioteca(printStream);
        view.printGreeting();
        view.printMenu();
        insertBooks();
        view.listBooks(books);
    }

    public void insertBooks(){
        books.add(new Book("1984", "George Orwell", 1947));
        books.add(new Book("Dracula", "Bram Stoker", 1897));
        books.add(new Book("Oliver Twist", "Charles Dickens", 1880));
        books.add(new Book("Frakenstein", "Mary Shelley", 1880));
    }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp(System.out);
        library.startBiblioteca();
    }
}
