package com.twu.biblioteca;

import javax.swing.text.View;
import java.io.*;
import java.util.*;

public class BibliotecaApp {

    private PrintStream printStream;
    private List<Book> books;
    private ViewBiblioteca view;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        //this.view = viewBiblioteca;
        view = new ViewBiblioteca(printStream);
        books = new ArrayList<>();
        insertBooks();
    }

    public BibliotecaApp(PrintStream printStream, ViewBiblioteca viewBiblioteca) {
//        this.printStream = printStream;
////        this.view = viewBiblioteca;
////        books = new ArrayList<>();
////        insertBooks();
        //super();
        this(printStream);
        this.view = viewBiblioteca;

    }

    public void startBiblioteca(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //view = new ViewBiblioteca(printStream);
        view.printGreeting();
        view.printMenu();
        //insertBooks();

        try {
            while(true){
                Integer action = Integer.parseInt(input.readLine());
                selectOption(action);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectOption(Integer select){
        switch(select){
            case 1:
                view.listBooks(books);
                break;
            case 2:
                printStream.println("checkout");
                break;
            case 3:
                printStream.println("return book");
                break;
            case 4:
                printStream.println("Goodbye! You are now exiting the Biblioteca.");
                System.exit(0);
                break;
            default:
                printStream.println("Please select a valid option");
                break;
        }
    }

    public void insertBooks(){
        System.out.println("creating books");
        books.add(new Book("1984", "George Orwell", 1947));
        books.add(new Book("Dracula", "Bram Stoker", 1897));
        books.add(new Book("Oliver Twist", "Charles Dickens", 1880));
        books.add(new Book("Frakenstein", "Mary Shelley", 1880));
    }

    public static void main(String[] args) {
//        PrintStream out = System.out;
//        ViewBiblioteca view = new ViewBiblioteca(out);
//        BibliotecaApp library = new BibliotecaApp(out, view);
        BibliotecaApp library = new BibliotecaApp(System.out);
        library.startBiblioteca();
    }
}
