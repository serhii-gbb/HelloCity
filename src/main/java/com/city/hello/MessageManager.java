package com.city.hello;

import com.city.hello.enum_package.PartsOfDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

public class MessageManager {

    private final Logger LOGGER = LoggerFactory.getLogger(MessageManager.class);
    private final String ISO8859_1_ENCODING = "ISO8859-1";

    private ResourceBundle resourceBundle;


    public MessageManager(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }


    public String getMessage(PartsOfDay partOfDay, String cityName) {
        String message = "";

        try {
            String resourceBundleString = resourceBundle.getString(partOfDay.name());

            message = new String(resourceBundleString.getBytes(ISO8859_1_ENCODING), Charset.defaultCharset());

        } catch (UnsupportedEncodingException e) {
            LOGGER.error(e.getMessage());
        }

        return String.format("%s, %s!", message, cityName);
    }

}
