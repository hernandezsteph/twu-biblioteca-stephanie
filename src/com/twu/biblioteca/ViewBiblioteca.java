package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class ViewBiblioteca {
    private PrintStream printStream;
    private BufferedReader input;

    public ViewBiblioteca(PrintStream printStream){
        this.printStream = printStream;

        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public void printGreeting(){
        printStream.println("Welcome to Bibliotecta. Your one-stop-shop for great book titles in Banglore");
    }

    public void printMenu() {
        printStream.println("MAIN MENU\n 1. List of Books \n 2. Checkout \n 3. Return Book \n 4. Quit");
    }

    public void listBooks(List<Book> titles){
        //printStream.println(String.format("%-20s%-18s%-1s", "TITLE", "AUTHOR", "YEAR"));
        for(Book book : titles){
            printStream.println(book.formatString());
        }
    }

    public void printAvailableBooks(List<Book> titles){
        printStream.println(String.format("%-20s%-18s%-10s%-1s", "TITLE", "AUTHOR", "YEAR", "ID"));
        for(Book book : titles){
            if(!book.isCheckedOut()){
                printStream.println(book.formatString());
            }
        }
    }
}
