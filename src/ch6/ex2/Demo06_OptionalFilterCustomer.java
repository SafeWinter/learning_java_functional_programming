package ch6.ex2;

import ch6.ex1.Customer;
import ch6.ex1.Customers;

public class Demo06_OptionalFilterCustomer {

	public static void main(String[] args) {
		Customer defaultCustomer = new Customer(0, "Default");
		
		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(0,   new Customer(0, "Default"));
		
		int id = 456;
		Customer current = customers.findOptionalCustomerWithID(id)
				.filter(i -> i.getId() > 400)
				.orElseGet(() -> 
					customers.findOptionalCustomerWithID(0).get());
		System.out.println(current);
	}
}
