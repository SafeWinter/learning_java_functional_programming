package ch6.ex2;

import java.util.Optional;
import java.util.function.Function;

import ch6.ex1.Customer;
import ch6.ex1.Customers;

public class Demo08_Optional_lambda_exp {

	public static void main(String[] args) {

		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(0, new Customer(0, "Default"));
		
		int id = 789;
		Optional<Customer> optionalCustomer = customers.findOptionalCustomerWithID(id);

		Function<? super Customer, Customer> processMary = x -> {
			if (x.getName().equals("Mary")) {
				System.out.println("Processing Mary");
			}
			return x;
		};
		Function<? super Customer, Customer> processNotMary = x -> {
			if (!x.getName().equals("Mary")) {
				System.out.println(x);
			}
			return x;
		};

		Function<? super Customer, Customer> processCustomer = x -> {
			if (x.getName().equals("Mary")) {
				System.out.println("Processing Mary");
			} else {
				System.out.println(optionalCustomer.get());
			}
			return x;
		};
		
		// several lambda expressions
		try {
			id = 789;
			Customer current1 = customers
					.findOptionalCustomerWithID(id)
					.map(processMary)
					.map(processNotMary)
					.orElseThrow(NoCustomerFoundException::new);
			System.out.println(current1);
		} catch (NoCustomerFoundException ex) {
			ex.printStackTrace();
		}
		
		// combined version
		try {
			id = 789;
			Customer current2 = customers
					.findOptionalCustomerWithID(id)
					.map(processCustomer)
					.orElseThrow(NoCustomerFoundException::new);
			System.out.println(current2);
		} catch (NoCustomerFoundException ex) {
			ex.printStackTrace();
		}
	}
}


class NoCustomerFoundException extends Exception {
	public NoCustomerFoundException() { super(); }
	public NoCustomerFoundException(String errMsg) {
		super(errMsg);
	}
}
