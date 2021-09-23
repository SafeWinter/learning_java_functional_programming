package ch3.ex2;

public class Demo15_MultipleInheritance implements FirstBaseInterface, SecondBaseInterface {
    
	public void display() {
		System.out.println("Display result: ");
		FirstBaseInterface.super.display();
		SecondBaseInterface.super.display();
	}
	
    public static void main(String[] args) {
    	new Demo15_MultipleInheritance().display();
    }
}

interface FirstBaseInterface {
	default void display() {
		System.out.println("From FirstBaseInterface");
	}
}

interface SecondBaseInterface {
	default void display() {
		System.out.println("From SecondBaseInterface");
	}
}

