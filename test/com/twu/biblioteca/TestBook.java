package com.twu.biblioteca;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestBook {

    @Test
    public void testToString(){
        Book book = new Book("1984", "George Orwell", 1947);
        String expected = "1984, George Orwell, 1947";

        assertThat(book.toString(), is(expected));
    }

    @Test
    public void testFormatString(){
        Book book = new Book("Dracula", "Bram Stoker", 1897);
        String expected = String.format("| %-10s | %-15s | %-10s\n", "Dracula", "Bram Stoker", "1897");

        assertThat(book.formatString(), is(expected));
    }

}
