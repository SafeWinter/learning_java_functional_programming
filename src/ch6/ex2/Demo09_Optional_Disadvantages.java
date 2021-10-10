package ch6.ex2;

import java.util.Optional;

public class Demo09_Optional_Disadvantages {

    public static void main(String[] args) {
        /* Exception thrown if Line 31 is used:
        Exception in thread "main" java.util.NoSuchElementException: No value present
            at java.base/java.util.Optional.get(Optional.java:148)
            at ch6.ex2.OptCustomer.<init>(Demo09_Optional_Disadvantages.java:24)
            at ch6.ex2.Demo09_Optional_Disadvantages.main(Demo09_Optional_Disadvantages.java:8)
        */
        OptCustomer optCustomer = new OptCustomer(123, Optional.empty());
        System.out.println(optCustomer);
    }

}

class OptCustomer {
    private int id;
    private String name;
    
    public OptCustomer(int id) {
        this.id = id;
        this.name = "Default Name";
    }
    
    public OptCustomer(int id, Optional<String> name) {
        this.id = id;
//        this.name = name.get();
        this.name = name.isPresent() ? name.get() : "Default Name";
    }

    @Override
    public String toString() {
        return "OptCustomer [id=" + id + ", name=" + name + "]";
    }
}