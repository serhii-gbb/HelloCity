package com.city.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class ParametersReader {

    private final Logger LOGGER = LoggerFactory.getLogger(ParametersReader.class);
    private BufferedReader bufferedReader;


    public ParametersReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }



    public String readCity() {
        Pattern pattern = Pattern.compile("[\\d_!@#$%^&*()\\-+]");

        while (true) {

            try {
                System.out.print("Введите название города: ");

                String city = bufferedReader.readLine().trim();

                if (city.isEmpty() || pattern.matcher(city).find()) {
                    LOGGER.info("ОШИБКА ВВОДА!!! Параметр обязателен и должен содержать только латинские буквы!");

                    continue;
                }

                return city;

            } catch (IOException e) {
                LOGGER.error(e.getMessage());
            }
        }
    }



    public String readTimeZone() {
        String city = "";

        try {
            System.out.print("Введите часовой пояс (ENTER пропустить): ");

            city = bufferedReader.readLine().trim();

        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }

        return city;
    }

}
