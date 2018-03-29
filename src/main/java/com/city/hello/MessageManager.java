package com.city.hello;

import com.city.hello.enum_package.PartsOfDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class MessageManager {

    private final Logger logger = LoggerFactory.getLogger(MessageManager.class);
    private final String CHARSET_ENCODING = "UTF-8";

    private ResourceBundle resourceBundle;


    public MessageManager(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }



    public String getMessage(PartsOfDay partOfDay, String cityName) {
        String message = "";

        try {
            String resourceBundleString = resourceBundle.getString(partOfDay.name());

            message = new String(resourceBundleString.getBytes(), CHARSET_ENCODING);

        } catch (UnsupportedEncodingException e) {
            logger.error(e.getMessage());
        }

        return String.format("%s, %s!", message, cityName);
    }

}
