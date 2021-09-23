package ch3.ex2;

public class Demo14_FluentInterfaceExtension {
    
    public static void main(String[] args) {
        // test
    	SailBoat sailBoat1 = new SailBoat()
	        .name("Endeavour")
	        .country("United Kingdom")
	        .sails(3)
	        .tonnage(15)
	        .hulls(2);
        System.out.println(sailBoat1);
        
        // change the assignment order
        sailBoat1.tonnage(15)
                .hulls(2)
                .country("United Kingdom")
                .name("Endeavour")
                .sails(3);
        System.out.println(sailBoat1);
    }
}

class SailBoat extends BaseBoat<SailBoat> {
	private int numberOfSails;
    private int numberOfHulls;
    
	public int getNumberOfSails() {
		return numberOfSails;
	}
	public SailBoat sails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
		return this;
	}
	public int getNumberOfHulls() {
		return numberOfHulls;
	}
	public SailBoat hulls(int numberOfHulls) {
		this.numberOfHulls = numberOfHulls;
		return this;
	}

	@Override
	public String toString() {
		return super.toString() + ", numberOfSails: " + numberOfSails + ", numberOfHulls: " + numberOfHulls;
	}
}

class BaseBoat<DERIVED extends BaseBoat<DERIVED>> {
	private String name;
	private String country;
	private int tonnage;
	private int draft;
	
	public String getName() {
		return name;
	}
	@SuppressWarnings("unchecked")
	public DERIVED name(String name) {
		this.name = name;
		return (DERIVED)this;
	}
	public String getCountry() {
		return country;
	}
	@SuppressWarnings("unchecked")
	public DERIVED country(String country) {
		this.country = country;
		return (DERIVED)this;
	}
	public int getTonnage() {
		return tonnage;
	}
	@SuppressWarnings("unchecked")
	public DERIVED tonnage(int tonnage) {
		this.tonnage = tonnage;
		return (DERIVED)this;
	}
	public int getDraft() {
		return draft;
	}
	@SuppressWarnings("unchecked")
	public DERIVED draft(int draft) {
		this.draft = draft;
		return (DERIVED)this;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + ", Country: " + this.country
                + ", Tonnage: " + this.tonnage + ", Draft: " + this.draft;
	}
	
}