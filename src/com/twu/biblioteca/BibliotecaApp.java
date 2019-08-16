package com.twu.biblioteca;

import javax.swing.text.View;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BibliotecaApp {

    private PrintStream printStream;
    private List<Book> books;
    private ViewBiblioteca view;
    private BufferedReader input;

    public BibliotecaApp(PrintStream printStream){
        this.printStream = printStream;
        view = new ViewBiblioteca(printStream);
        input = new BufferedReader(new InputStreamReader(System.in));
        books = new ArrayList<>();
        insertBooks();
    }

    /*
        test purposes ONLY
     */
    public BibliotecaApp(PrintStream printStream, ViewBiblioteca viewBiblioteca) {
        this(printStream);
        this.view = viewBiblioteca;

    }

    public void startBiblioteca(){
        view.printGreeting();
        view.printMenu();

        while(true){
            Integer action = getInput();
            selectOption(action);
        }
    }

    public Integer getInput(){
        try {
            return Integer.parseInt(input.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void selectOption(Integer select){
        switch(select){
            case 1:
                view.listBooks(books);
                break;
            case 2:
                checkOutBook();
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

    public void checkOutBook(){
        printStream.println("Which book would you like to checkout?\nEnter ID of selected book.");
        view.printAvailableBooks(books);

        Integer selectedBook = getInput();
        Book checkOut = getBook(selectedBook);
        if(checkOut == null){
            printStream.println("Please select a valid book.");
            checkOutBook();
        }
        else {
            checkOut.checkedOut();
            printStream.println("Thank you! Enjoy the book!");
            System.out.println(checkOut.toString());
        }

    }

    public Book getBook(int id){
        Book found = null;
        for(Book title : books){
            if(title.getId() == id && !title.isCheckedOut()){
                found = title;
            }
        }
        return found;
    }

    public void insertBooks(){
        System.out.println("creating books");
        books.add(new Book("1984", "George Orwell", 1947,1 ));
        books.add(new Book("Dracula", "Bram Stoker", 1897,2 ));
        books.add(new Book("Oliver Twist", "Charles Dickens", 1880,3 ));
        books.add(new Book("Frakenstein", "Mary Shelley", 1880,4 ));
    }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp(System.out);
        library.startBiblioteca();
    }
}
