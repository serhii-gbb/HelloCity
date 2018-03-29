package com.city.hello;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.zone.ZoneRulesException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TimeZoneDefinerTest {

    private ParametersReader parametersReader;
    private String cityName;
    private String timeZone;

    @Before
    public void setUp() {
        parametersReader = mock(ParametersReader.class);
        cityName = "city";
        timeZone = "timeZone";

    }



    @Test(expected = ZoneRulesException.class)
    public void defineTimeZone() {
        doThrow(ZoneRulesException.class).when(parametersReader).readTimeZone();

        when(parametersReader.readCity()).thenReturn(cityName);
        when(parametersReader.readTimeZone()).thenReturn(timeZone);

        assertEquals(parametersReader.readCity(), cityName);
        assertEquals(parametersReader.readTimeZone(), timeZone);

        verify(parametersReader, only()).readCity();
        verify(parametersReader, atLeastOnce()).readTimeZone();
    }
}