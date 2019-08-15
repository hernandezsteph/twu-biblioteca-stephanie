package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

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
    public void testMenu(){

    }


}
