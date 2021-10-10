package ch6.ex2;

import java.util.function.Function;

import ch6.ex1.Customer;
import ch6.ex1.Customers;

public class Demo08_Optional_3LambdaExp {

    public static void main(String[] args) {
        Customers customers = getCustomers();
        findCustomerId(789, customers);

        findCustomerIdMerged(1234, customers);
    }

    private static void findCustomerIdMerged(int id, Customers customers) {
        Function<? super Customer, Customer> processCustomer = 
                x -> {
                    if(x.getName().equals("Mary")) {
                        System.out.println("Processing Mary");
                    } else {
                        System.out.println(x);
                    }
                    return x;
                }; 
        try {
            Customer current = customers.findOptionalCustomerWithID(id)
                    .map(processCustomer)
                    .orElseThrow(NoCustomerFoundException::new);
            System.out.println(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void findCustomerId(int id, Customers customers) {
        Function<? super Customer, Customer> processMary = 
                x -> {
                    if(x.getName().equals("Mary")) {
                        System.out.println("Precessing Mary");
                    }
                    return x;
                };
        Function<? super Customer, Customer> processNotMary = 
                x -> {
                    if(!x.getName().equals("Mary")) {
                        System.out.println(x);
                    }
                    return x;
                };
                
        try {
            Customer current = customers.findOptionalCustomerWithID(id)
                    .map(processMary)
                    .map(processNotMary)
                    .orElseThrow(NoCustomerFoundException::new);
            System.out.println(current);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Customers getCustomers() {
        Customers customers = new Customers()
                .addCustomer(123, new Customer(123, "Sue"))
                .addCustomer(456, new Customer(456, "Bob"))
                .addCustomer(789, new Customer(789, "Mary"))
                .addCustomer(0, new Customer(0, "Default"));
        return customers;
    }
}

class NoCustomerFoundException extends Exception {
    private static final long serialVersionUID = -2471311209778911693L;
    public NoCustomerFoundException() { super(); }
    public NoCustomerFoundException(String errMsg) {
        super(errMsg);
    }
}
