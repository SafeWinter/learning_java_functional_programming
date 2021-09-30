package ch6.ex1;

import java.util.HashMap;
import java.util.Optional;

public class Customers {
	
	private HashMap<Integer, Customer> customers;

	public Customers() {
		super();
		this.customers = new HashMap<>();
	}
	
	public Customers addCustomer(int id, Customer customer) {
        customers.put(id, customer);
        return this;
    }
	
	public Customer findCustomerWithID(int id) {
		if(customers.containsKey(id)) {
			return customers.get(id);
		} else {
			return null;
		}
	}
	
	public Optional<Customer> findOptionalCustomerWithID(int id) {
		if(customers.containsKey(id)) {
			return Optional.of(customers.get(id));
		} else {
			return Optional.empty();
		}
	}

}
