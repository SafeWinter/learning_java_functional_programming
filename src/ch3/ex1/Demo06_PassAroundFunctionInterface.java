package ch3.ex1;

import java.util.function.Function;

public class Demo06_PassAroundFunctionInterface {

    public static void main(String[] args) {
        Function<Salesman2, Manager> salseToManager      = Salesman2::getManager;
        Function<Manager, String>    managerToEmail      = Manager::getEmailAddress;
        Function<Salesman2, String>  salseToManagerEmail = salseToManager.andThen(managerToEmail);
        
        Manager manager = new Manager("manager@thecompany.com");
        Salesman2 salesman2 = new Salesman2(manager);
        System.out.println(salseToManagerEmail.apply(salesman2));      // manager@thecompany.com
        System.out.println(salesman2.getManager().getEmailAddress());  // manager@thecompany.com
    }
    
}

class Customer2 {
    private String emailAddress;

    public Customer2(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}

class Salesman2 {
    private Customer2 bestCustomer;
    
    private Manager manager;

    public Salesman2(Customer2 bestCustomer) {
        this.bestCustomer = bestCustomer;
    }
    
    public Salesman2(Manager manager) {
        this.manager = manager;
    }

    public Customer2 getBestCustomer() {
        return bestCustomer;
    }
    
    public Manager getManager() {
        return manager;
    }
}

class Manager {
    private String emailAddress;

    public Manager(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailAddress() {
        return emailAddress;
    }    
}