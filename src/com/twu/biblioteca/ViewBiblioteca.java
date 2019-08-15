package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;

public class ViewBiblioteca {
    private PrintStream printStream;
    private BufferedReader input;
    private Map<String, String> books = new HashMap<String,String>();

    public ViewBiblioteca(PrintStream printStream){
        this.printStream = printStream;

        input = new BufferedReader(new InputStreamReader(System.in));
        insertBooks();
    }

    public void insertBooks(){
        books.put("1984", "George Orwell");
        books.put("Fahrenheit 451", "fjdk");
        books.put("Oliver Twist", "Charles Dickens");
        books.put("Pride and Prejudice", "Jane Austen");
    }


    public void printGreeting(){
        printStream.println("Welcome to Bibliotecta. Your one-stop-shop for great book titles in Banglore");
    }

    public void printMenu() {
        printStream.println("MAIN MENU\n 1. List of Books \n 2. Checkout \n 3. Return Book \n 4. Quit\n");

        try {
            Integer action = Integer.parseInt(input.readLine());
            printStream.println(action);
            selectOption(action);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void selectOption(Integer select){
        switch(select){
            case 1:
                printStream.println("hello");
                listBooks();
                break;
            case 2:
                printStream.println("checkout");
                break;
        }
    }

    public void listBooks(){
        for(String title : books.keySet()){
            printStream.println(title);
        }
    }



}
