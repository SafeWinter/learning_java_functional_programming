package ch3.ex1;

public class Demo04_BeforeFunctionInterface {

    public static void main(String[] args) {
        Customer customer = new Customer("bestcustomer@thebestcustomer.com");
        Salesman salesman = new Salesman(customer);
        System.out.println(salesman.getBestCustomer().getEmailAddress());
    }
    
}

class Customer {
    private String emailAddress;

    public Customer(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

class Salesman {
    private Customer bestCustomer;

    Salesman(Customer bestCustomer) {
        this.bestCustomer = bestCustomer;
    }

    public Customer getBestCustomer() {
        return bestCustomer;
    }
}