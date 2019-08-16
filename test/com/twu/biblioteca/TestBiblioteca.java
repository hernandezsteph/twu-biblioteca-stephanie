package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import javax.swing.text.View;
import java.io.*;
import java.util.*;
import java.util.Collections;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TestBiblioteca {
    private OutputStream os;
    private BibliotecaApp app;
    //private ViewBiblioteca view;

    @Before
    public void setUp(){
        os = new ByteArrayOutputStream();
        //PrintStream ps = new PrintStream(os);
        //app = new BibliotecaApp(ps);
        //view = new ViewBiblioteca(ps);
    }

    @Test
    public void listOfBooksInput(){
        // GIVEN
        PrintStream ps = new PrintStream(os);
        ViewBiblioteca mockView = mock(ViewBiblioteca.class);
        app = new BibliotecaApp(ps,  mockView);

        List<Book> testBook = new ArrayList<>();
        testBook.add(new Book("1984", "George Orwell", 1947, 1));
        testBook.add(new Book("Dracula", "Bram Stoker", 1897, 2));
        testBook.add(new Book("Oliver Twist", "Charles Dickens", 1880,3 ));
        testBook.add(new Book("Frakenstein", "Mary Shelley", 1880,4 ));

        // WHEN
        app.selectOption(1);

        //THEN
        verify(mockView).listBooks(testBook);
    }
}

//    verify(mock).shouldbecalled(any(book.class));
//    when(mock.shouldbecalled(any(book.class))).thenreturn(true);

//pass scanner to app
//mock the scanner scanner = mock(scanner.class)
//when(mockscanner.nextline()).return("1"); when scanner is called return 1
//verify(mockprintsream).printlne(expected) mock followed by the function called and what we pass in
//println is only called once
//verificationmode.never() should never be called
