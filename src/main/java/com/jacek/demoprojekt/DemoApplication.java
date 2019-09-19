package com.jacek.demoprojekt;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        run(DemoApplication.class, args);
    }
}