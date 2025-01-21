package com.example.ProiectSP;

import com.example.ProiectSP.difexample.ClientComponent;
import com.example.ProiectSP.difexample.SingletonComponent;
import com.example.ProiectSP.difexample.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProiectSP {
    public static void main(String[] args) {
        SpringApplication.run(ProiectSP.class, args);
    }
}