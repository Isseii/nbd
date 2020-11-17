package com.example.mongodb.nbd;

import com.example.mongodb.nbd.IdGenerate.IdGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;

@SpringBootApplication

public class AccessMongoDB  {

    public static void main(String[] args) {
        SpringApplication.run(AccessMongoDB.class, args);
    }


}
