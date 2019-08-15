package com.twu.biblioteca;

import java.io.*;

public class BibliotecaApp {

    private PrintStream printStream;

    public BibliotecaApp(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void startBiblioteca(){
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        ViewBiblioteca view = new ViewBiblioteca(printStream);
        view.printGreeting();
        view.printMenu();
    }

    public static void main(String[] args) {
        BibliotecaApp library = new BibliotecaApp(System.out);
        library.startBiblioteca();
    }
}
