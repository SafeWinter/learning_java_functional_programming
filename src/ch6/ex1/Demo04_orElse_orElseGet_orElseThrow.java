package ch6.ex1;

import java.util.Optional;
import java.util.function.Consumer;

public class Demo04_orElse_orElseGet_orElseThrow {

	public static void main(String[] args) {
		
		Customer defaultCustomer = new Customer(0, "Default");
		
		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(defaultCustomer.getId(), defaultCustomer);
		
		int id = 789;
		// Optional version:
		Optional<Customer> optionalCustomer = customers.findOptionalCustomerWithID(id);
		Consumer<Customer> consume = o -> {
			if(o.getName().equals("Mary")) {
				System.out.println("Processing Mary");
			} else {
				System.out.println(o);
			}
		};
		optionalCustomer.ifPresent(consume);
	}
}
