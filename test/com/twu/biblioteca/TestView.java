package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestView {
    private OutputStream os;
    private ViewBiblioteca view;

    @Before
    public void setUp() throws Exception {
        os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        view = new ViewBiblioteca(ps);
    }

    @Test
    public void testGreeting(){
        view.printGreeting();
        String greeting = "Welcome to Bibliotecta. Your one-stop-shop for great book titles in Banglore\n";

        assertThat(os.toString(), is(equalTo(greeting)));
    }

    @Test
    public void testListofBooks(){
        Book a = new Book("Dracula", "Bram Stoker", 1897);
        Book b = new Book("1984", "George Orwell", 1947);
        List<String> titles = new ArrayList<>();
        titles.add(b.formatString());
        titles.add(a.formatString());

        List<Book> formatTitles = new ArrayList<>();
        formatTitles.add(new Book("1984", "George Orwell", 1947));
        formatTitles.add(new Book("Dracula", "Bram Stoker", 1897));

        view.listBooks(formatTitles);

        String output = os.toString();
        String[] lines = output.split("\n");
        List<String> books = Arrays.asList(lines);
        assertThat(books, is(titles));

    }

}
