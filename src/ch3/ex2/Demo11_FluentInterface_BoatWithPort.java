package ch3.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo11_FluentInterface_BoatWithPort {
    
    public static void main(String[] args) {
        
        Port port = new Port();
        Boat1 newBoat = port.add("Cloud")
                .country("Russia")
                .tonnage(80000)
                .draft(50);
        port.add(newBoat);
        
        Boat1 boat = new Boat1()
                .named("SecondBoat")
                .country("Panama")
                .tonnage(12000)
                .draft(25);
        port.add(boat);
        
        // used as part of an anonymous inner class
        port.add(new Boat1() {
            {
                named("Albatross");
                country("Panama");
                tonnage(1500);
                draft(35);
            }
        });
        
        /*
        port.add(new Boat1() {
            {
                this.named("Albatross");
                this.country("Panama");
                this.tonnage(1500);
                this.draft(35);
            }
        });
        */
        
        port.boats().forEach(System.out::println);
        
        System.out.println();
        
        // DIY extension: filter boats named "Cloud"
        BiFunction<String, String, Boolean>         compare2String = (s1, s2) -> s1.equals(s2);
        Function<String, Function<String, Boolean>> curryCompare   = s1 -> s2 -> compare2String.apply(s1, s2);
        Function<String, Boolean>                   testEqCloud    = curryCompare.apply("Cloud");
        Function<Boat1, String>                     getBoatName    = Boat1::getName;
        
        port.boats().parallelStream()
            .filter(getBoatName.andThen(testEqCloud)::apply)
            .forEach(System.out::println);
    }
}

class Port {
    private List<Boat1> boats = new ArrayList<>();
    
    public Boat1 add(String name) {
        Boat1 boat = new Boat1().named(name);
        boats.add(boat);
        return boat;
    }
    
    public Port add(Boat1 boat) {
        boats.add(boat);
        return this;
    }
    
    public List<Boat1> boats() {
        return boats;
    }
}

class Boat1 {
    
    private String name;
    private String country;
    private int tonnage;
    private int draft;
    
    public String getName() {
        return name;
    }
    public Boat1 setName(String name) {
        this.name = name;
        return this;
    }
    public Boat1 named(String name) {
        this.name = name;
        return this;
    }
    public String getCountry() {
        return country;
    }
    public Boat1 setCountry(String country) {
        this.country = country;
        return this;
    }
    public Boat1 country(String country) {
        this.country = country;
        return this;
    }
    public int getTonnage() {
        return tonnage;
    }
    public Boat1 setTonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }
    public Boat1 tonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }
    public int getDraft() {
        return draft;
    }
    public Boat1 setDraft(int draft) {
        this.draft = draft;
        return this;
    }
    public Boat1 draft(int draft) {
        this.draft = draft;
        return this;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + " Country: " + this.country
                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
    }
}