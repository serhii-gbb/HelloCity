package com.city.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class ParametersReader {

    private final Logger logger = LoggerFactory.getLogger(ParametersReader.class);
    private BufferedReader bufferedReader;


    public ParametersReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }



    public String readCity() {
        while (true) {

            try {
                System.out.print("Введите название города: ");
                String city = bufferedReader.readLine().trim();

                if (city.isEmpty()) {
                    logger.info("ОШИБКА ВВОДА!!! Параметр не может быть пустым!");

                    continue;
                }

                return city;

            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public String readTimeZone() {
        String city = "";

        try {
            System.out.print("Введите часовой пояс (ENTER пропустить): ");

            city = bufferedReader.readLine().trim();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        return city;
    }


}
