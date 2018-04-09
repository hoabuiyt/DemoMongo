package com.example.demomongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.wso2.msf4j.MicroservicesRunner;

@SpringBootApplication
public class DemomongoApplication{

	@Autowired
	private CustomerRepository repository;
	
	public static void main(String[] args) {
		//SpringApplication.run(TestServices.class, args);
		new MicroservicesRunner()
        .deploy(new CustomerServices())
        .start();
	}	
	
}
