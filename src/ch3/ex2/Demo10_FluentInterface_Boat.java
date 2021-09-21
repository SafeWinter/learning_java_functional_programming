package ch3.ex2;

public class Demo10_FluentInterface_Boat {
    
    public static void main(String[] args) {
        Boat boat = new Boat();
        boat.setName("Albatross");
        boat.setCountry("Panama");
        boat.setTonnage(12000);
        boat.setDraft(25);
        
        System.out.println(boat);
        
        boat.setName("boat1")
            .setCountry("China")
            .setTonnage(21000)
            .setDraft(30);
        
        System.out.println(boat);
        
        boat.named("boat2")
            .country("USA")
            .tonnage(30000)
            .draft(40);
        
        System.out.println(boat);
    }
}

class Boat {
    
    private String name;
    private String country;
    private int tonnage;
    private int draft;
    
    public String getName() {
        return name;
    }
    public Boat setName(String name) {
        this.name = name;
        return this;
    }
    public Boat named(String name) {
        this.name = name;
        return this;
    }
    public String getCountry() {
        return country;
    }
    public Boat setCountry(String country) {
        this.country = country;
        return this;
    }
    public Boat country(String country) {
        this.country = country;
        return this;
    }
    public int getTonnage() {
        return tonnage;
    }
    public Boat setTonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }
    public Boat tonnage(int tonnage) {
        this.tonnage = tonnage;
        return this;
    }
    public int getDraft() {
        return draft;
    }
    public Boat setDraft(int draft) {
        this.draft = draft;
        return this;
    }
    public Boat draft(int draft) {
        this.draft = draft;
        return this;
    }
    
    @Override
    public String toString() {
        return "Name: " + this.name + " Country: " + this.country
                + " Tonnage: " + this.tonnage + " Draft: " + this.draft;
    }
}