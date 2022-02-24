package org.isamary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DisneyApp {

    public static void main(String[] args) {
        SpringApplication.run(DisneyApp.class, args);
        System.out.println("ejecutando main");
    }
}
