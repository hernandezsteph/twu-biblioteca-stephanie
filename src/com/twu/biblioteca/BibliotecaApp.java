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
        //input = new BufferedReader(new InputStreamReader(System.in));
        books = new ArrayList<>();
        insertBooks();
    }

    /*
        test purposes ONLY
     */
    public BibliotecaApp(PrintStream printStream, ViewBiblioteca viewBiblioteca, BufferedReader reader) {
        //this(printStream);
        this.printStream = printStream;
        this.view = viewBiblioteca;
        this.input = reader;
        books = new ArrayList<>();
        insertBooks();

    }

    public void startBiblioteca(){
        view.printGreeting();
        view.printMenu();

        while(true){
            Integer action = getInput();
            selectOption(action);
        }
    }
    //TODO: FIX TO HANDLE STRING INPUTS
    public Integer getInput(){
        try {
            String line = input.readLine();
            return Integer.parseInt(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void selectOption(Integer select){
        switch(select){
            case 1:
                view.listBooks(books);
                view.printMenu();
                break;
            case 2:
                checkOutBook();
                view.printMenu();
                break;
            case 3:
                returnBook();
                view.printMenu();
                break;
            case 4:
                printStream.println("Goodbye! You are now exiting the Biblioteca.");
                System.exit(0);
                break;
            default:
                printStream.println("Please select a valid option");
                view.printMenu();
                break;
        }
    }

    public void checkOutBook(){
        printStream.println("Which book would you like to checkout?\nEnter ID of selected book.");
        view.printAvailableBooks(books);

        Integer selectedBook = getInput();
        Book checkOut = getBook(selectedBook);
        if(checkOut == null || checkOut.isCheckedOut()){
            printStream.println("Please select a valid book.");
            checkOutBook();
        }
        else if(!checkOut.isCheckedOut()){
            checkOut.checkedOut();
            printStream.println("Thank you! Enjoy the book!");
            System.out.println(checkOut.toString());
        }
    }

    public void returnBook(){
        printStream.println("Whick book would you like to return?\nEnter ID of selected book.");
        view.listBooks(books);

        Integer selectedBook = getInput();
        Book returnedBook = getBook(selectedBook);

        if(returnedBook == null || !returnedBook.isCheckedOut()){
            printStream.println("Please return a valid book");
            returnBook();
        }
        else if(returnedBook.isCheckedOut()){
            returnedBook.returnBook();
            printStream.println("Thank you for returning the book!");
        }
    }

    public Book getBook(int id){
        Book found = null;
        for(Book title : books){
            if(title.getId() == id){
                found = title;
            }
        }
        return found;
    }

    public void insertBooks(){
        //System.out.println("creating books");
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
