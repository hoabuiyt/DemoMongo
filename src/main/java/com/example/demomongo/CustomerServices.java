package com.example.demomongo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.wso2.msf4j.Microservice;


@Path("/demomongo")
public class CustomerServices implements Microservice{

	@Autowired
	private CustomerRepository repository;
	
	@GET
	@Path("/get1")
    public String get() {
        System.out.println("GET 11111");
        return "Test thanh cong !";
    }
	
	@GET
	@Path("/get2")
	public Customer get2() {
		System.out.println("GET 22222");		
		try {
			repository.deleteAll();

			// save a couple of customers
			repository.save(new Customer("Alice", "Smith"));
			repository.save(new Customer("Bob", "Smith"));
			
			// fetch an individual customer
			System.out.println("Customer found with findByFirstName('Alice'):");
			System.out.println("--------------------------------");
			System.out.println(repository.findByFirstName("Alice"));
			
			return repository.findByFirstName("Alice");
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
        
    }
	
}
