package com.city.hello;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ParametersReaderTest {

    private BufferedReader bufferedReader;


    @Before
    public void setUp() {
        bufferedReader = mock(BufferedReader.class);
    }

    @After
    public void tearDown() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readCity() throws IOException {

        when(bufferedReader.readLine()).thenReturn("city");

        assertEquals(bufferedReader.readLine(), "city");
        assertFalse(bufferedReader.readLine().isEmpty());

        when(bufferedReader.readLine()).thenReturn("c i t y");

        assertEquals(bufferedReader.readLine(), "c i t y");
        assertFalse(bufferedReader.readLine().isEmpty());


        verify(bufferedReader, times(4)).readLine();
    }

    @Test
    public void readTimeZone() throws IOException {

        when(bufferedReader.readLine()).thenReturn("timeZone");
        assertEquals(bufferedReader.readLine(), "timeZone");

        when(bufferedReader.readLine()).thenReturn("");
        assertTrue(bufferedReader.readLine().isEmpty());


        verify(bufferedReader, atLeastOnce()).readLine();
    }
}