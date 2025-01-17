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

	private static final Logger log;

	static {
		System.setProperty("java.util.logging.SimpleFormatter.format", "[%4$-7s] %5$s %n");
		log = Logger.getLogger(DemoApplication.class.getName());
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		String serviceName = System.getenv("SPRING_DATASOURCE_URL");
		System.out.println(serviceName);


		try {
			// call methods that might throw SQLException
			Connection connection = DriverManager.getConnection(serviceName);
			System.out.println(connection);
		} catch (SQLException e) {
			// do something appropriate with the exception, *at least*:
			e.printStackTrace();
		}
		return "hello";
	}
}
