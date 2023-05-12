package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		 String serviceName = System.getenv("ConnectDB");
		
		log.info("Connecting to the database");
        	Connection connection = DriverManager.getConnection(serviceName);
        	log.info("Database connection test: " + connection.getCatalog());
		return "Hello World!";
	}
}
