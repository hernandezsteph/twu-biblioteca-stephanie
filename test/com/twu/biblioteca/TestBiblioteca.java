package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
    private PrintStream ps;
    private ViewBiblioteca view;

    @Before
    public void setUp(){
        os = new ByteArrayOutputStream();
        ps = new PrintStream(os);
        //app = new BibliotecaApp(ps);
        view = new ViewBiblioteca(ps);
    }

    @Test
    public void getInput(){

    }

    @Test
    public void listOfBooksInput(){
        // GIVEN
        ViewBiblioteca mockView = mock(ViewBiblioteca.class);
        app = new BibliotecaApp(ps, mockView, new BufferedReader(new InputStreamReader(System.in)));

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

    @Test
    public void checkOutBook() throws IOException {
        //GIVEN
        //PrintStream mockPS = mock(PrintStream.class);
        BufferedReader mockReader = mock(BufferedReader.class);
        //when(mockReader.readLine()).thenReturn("2");

       // app = new BibliotecaApp(ps, view, mockReader);
       // app = mock(BibliotecaApp.class);
        //Mockito.doReturn(1).when(app).getInput();
        app = Mockito.spy(new BibliotecaApp(ps, view, mockReader));
        Mockito.doReturn(1).when(app).getInput();

        //WHEN
        app.selectOption(2);
        //when(mockReader.readLine()).thenReturn("2");
        // when(mockReader.readLine()).thenReturn("1");
       // when(app.getInput()).thenReturn(1);

        //THEN
        verify(app).checkOutBook();
    }

//    @Test
//    public void returnBook(){
//        // TODO: MAKE SURE A BOOK IS CHECKED OUT
//        BufferedReader mockReader = mock(BufferedReader.class);
//
//        app = Mockito.spy(new BibliotecaApp(ps, view, mockReader));
//        Mockito.doReturn(1).when(app).getInput();
//
//        app.selectOption(3);
//
//        verify(app).returnBook();
//
//    }

    @Test
    public void invalidInput(){
        ViewBiblioteca mockView = mock(ViewBiblioteca.class);
        app = new BibliotecaApp(ps, mockView, new BufferedReader(new InputStreamReader(System.in)));

        // WHEN
        app.selectOption(5);

        //THEN
        assertThat(os.toString(),is(equalTo("Please select a valid option\n")));
        verify(mockView).printMenu();
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
