package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestBook {

    @Test
    public void testToString(){
        Book book = new Book("1984", "George Orwell", 1947, 1);
        String expected = "1984, George Orwell, 1947";

        assertThat(book.toString(), is(expected));
    }

    @Test
    public void testFormatString(){
        Book book = new Book("Dracula", "Bram Stoker", 1897, 2);
        String expected = String.format("|| %-15s || %-15s || %-1s", "Dracula", "Bram Stoker", "1897");

        assertThat(book.formatString(), is(expected));
    }

}
