package com.city.hello;


import com.city.hello.enum_package.PartsOfDay;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.UnsupportedEncodingException;
import java.util.*;

import static org.junit.Assert.*;

public class MessageManagerTest {

    private ResourceBundle resourceBundle;

    @Before
    public void setUp() {
        resourceBundle = new ResourceBundle() {
            @Override
            protected Object handleGetObject(String key) {
                return "Good morning";
            }

            @Override
            public Enumeration<String> getKeys() {
                return Collections.emptyEnumeration();
            }
        };

    }

    @Test
    public void getMessage() throws UnsupportedEncodingException {
        String bundleString = resourceBundle.getString(PartsOfDay.MORNING.name());

        assertEquals(bundleString, "Good morning");
        assertEquals(new String(bundleString.getBytes("UTF-8")), bundleString);

    }
}