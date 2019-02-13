package com.lambdaschool.javacities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaCitiesApplication {

    public static final String EXCHANGE_NAME = "MessageServer";
    public static final String QUEUE_NAME_SECRET = "SecretQueue";
    public static final String QUEUE_NAME_CITIES1 = "Cities1Queue";
    public static final String QUEUE_NAME_CITIES2 = "Cities2Queue";


    public static void main(String[] args) {
        SpringApplication.run(JavaCitiesApplication.class, args);
    }

}

