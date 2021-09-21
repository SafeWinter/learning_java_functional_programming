package ch3.ex1;

import java.util.function.Function;

public class Demo05_AfterFunctionInterface {

    public static void main(String[] args) {
        Function<Salesman1, Customer1> salsemanToBestCustomer
                = Salesman1::getBestCustomer;
        Function<Customer1, String> customerToEmailAddress
                = Customer1::getEmailAddress;
        Function<Salesman1, String> salsemanToBestCustomerEmail
                = salsemanToBestCustomer.andThen(customerToEmailAddress);
        
        Customer1 customer = new Customer1("bestcustomer@thebestcustomer.com");
        Salesman1 salesman = new Salesman1(customer);
        System.out.println(salsemanToBestCustomerEmail.apply(salesman));
    }
    
}

class Customer1 {
    private String emailAddress;

    public Customer1(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

class Salesman1 {
    private Customer1 bestCustomer;

    Salesman1(Customer1 bestCustomer) {
        this.bestCustomer = bestCustomer;
    }

    public Customer1 getBestCustomer() {
        return bestCustomer;
    }
}