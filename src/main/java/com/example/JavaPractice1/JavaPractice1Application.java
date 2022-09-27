package com.example.JavaPractice1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.JavaPractice1.domain.Car;
import com.example.JavaPractice1.domain.CarRepository;
import com.example.JavaPractice1.domain.Owner;
import com.example.JavaPractice1.domain.OwnerRepository;


@SpringBootApplication
public class JavaPractice1Application {
	private static final Logger logger= LoggerFactory.getLogger(JavaPractice1Application.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;

	public static void main(String[] args) {
		SpringApplication.run(JavaPractice1Application.class, args);
		logger.info("Hello Spring Boot");
	}
	
	@Bean
	 CommandLineRunner runner(){
		 return args -> {
		 // Place your code here, save demo data to database
			 
			// Add owner objects and save these to db
			 Owner owner1 = new Owner("John" , "Johnson");
			 Owner owner2 = new Owner("Mary" , "Robinson");
			 orepository.save(owner1);
			 orepository.save(owner2);

			 //Add cars with owners listed in their constructor
			 repository.save(new Car("Ford", "Mustang", "Red","ADF-1121", 2017, 59000, owner1));
			 repository.save(new Car("Nissan", "Leaf", "White","SSJ-3002", 2014, 29000, owner2));
			 repository.save(new Car("Toyota", "Prius", "Silver","KKO-0212", 2018, 39000, owner2));
		 };
	 } 


}
