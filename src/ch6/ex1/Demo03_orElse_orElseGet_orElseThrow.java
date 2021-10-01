package ch6.ex1;

public class Demo03_orElse_orElseGet_orElseThrow {

	public static void main(String[] args) {
		
		Customer defaultCustomer = new Customer(0, "Default");
		
		Customers customers = new Customers()
				.addCustomer(123, new Customer(123, "Sue"))
				.addCustomer(456, new Customer(456, "Bob"))
				.addCustomer(789, new Customer(789, "Mary"))
				.addCustomer(defaultCustomer.getId(), defaultCustomer);
		
		int id = 456;
		
		// orElse:
		Customer current = customers.findOptionalCustomerWithID(id)
			.orElse(defaultCustomer);
		System.out.println(current);
		
		
		// orElseGet:
		current = customers.findOptionalCustomerWithID(id)
			.orElseGet(() -> defaultCustomer);
		System.out.println(current);
		
		
		// orElseThrow:
		try {
			current = customers.findOptionalCustomerWithID(id)
				.orElseThrow(NoCustomerFoundException::new);
			System.out.println(current);
		} catch (NoCustomerFoundException e) {
			// Handle exception
			String errMsg = "Exception: " + e.getLocalizedMessage();
			System.out.println(errMsg);
		}
	}
}

class NoCustomerFoundException extends Exception {
	public NoCustomerFoundException() { super(); }
	public NoCustomerFoundException(String errMsg) {
		super(errMsg);
	}
}
