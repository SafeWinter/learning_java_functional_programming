package ch6.ex2;

import java.util.Optional;

import ch6.ex1.Customer;
import ch6.ex1.Customers;

public class Demo07_OptionalMapCustomer {

	public static void main(String[] args) {
		
		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(0,   new Customer(0, "Default"));
		
		int id = 456;
	    String name;
	    // Conventional way
	    Optional<Customer> optCustomer = customers.findOptionalCustomerWithID(id);
	    if(optCustomer.isPresent()) {
	    	name = optCustomer.get().getName().trim();
	    } else {
	    	name = "No Name";
	    }
	    System.out.println(name);
	    
	    // Optional map way
	    name = customers.findOptionalCustomerWithID(id)
	    		.map(o -> o.getName().trim())
	    		.orElse("No Name");
	    System.out.println(name);
	}
}
