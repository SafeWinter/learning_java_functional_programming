package ch6.ex1;

import java.util.Optional;

public class Demo02_isPresent_get {

	public static void main(String[] args) {
		
		Customer defaultCustomer = new Customer(0, "Default");
		
		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(defaultCustomer.getId(), defaultCustomer);
		
		int id = 789;
		
		// Conventional version:
		Customer customer = customers.findCustomerWithID(id);
		if(customer != null) {
			if(customer.getName().equals("Mary")) {
				System.out.println("Processing Mary");
			} else {
				System.out.println(customer);
			}
		} else {
			System.out.println(defaultCustomer);
		}
		
		// Optional version:
		Optional<Customer> optionalCustomer = customers.findOptionalCustomerWithID(id);
		if(optionalCustomer.isPresent()) {
			if(optionalCustomer.get().getName().equals("Mary")) {
				System.out.println("Processing optional Mary");
			} else {
				System.out.println(optionalCustomer.get());
			}
		} else {
			System.out.println(defaultCustomer);
		}
	}
}
