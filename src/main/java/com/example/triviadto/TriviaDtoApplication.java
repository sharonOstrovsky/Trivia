package com.example.triviadto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;

@SpringBootApplication
public class TriviaDtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TriviaDtoApplication.class, args);

        HashSet<Integer> number = new HashSet<>();
        number.add(1);
        number.add(1);
        number.add(2);
    }

}
