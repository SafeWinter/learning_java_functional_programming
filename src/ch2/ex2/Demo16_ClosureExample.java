package ch2.ex2;

import java.util.function.Consumer;
import java.util.function.Function;

public class Demo16_ClosureExample {
	
	private int instanceLength;
	
	public Function<String, String> getStringOperation1() {
		String separator = ":";
		return target -> {
			int localLength = target.length();
			instanceLength = target.length();
			return target.toLowerCase()
					+ separator + instanceLength + separator + localLength;
		};
	}
	
	public Function<String, String> getStringOperation2() {
		String separator = ":";
		return target -> {
			int localLength = target.length();
			instanceLength = target.length() + 1;  // could be varied on initial assignment
			return target.toLowerCase()
					+ separator + instanceLength + separator + localLength;
		};
	}
	
	public Function<String, String> getStringOperation3() {
		String separator = ":";
		return target -> {
			int localLength = target.length();
			// instanceLength = target.length();   // remain the same
			return target.toLowerCase()
					+ separator + instanceLength + separator + localLength;
		};
	}
	
	public Function<String, String> getStringOperation4() {
		String separator = ":";
		// separator = "::";  // Local variable separator defined in an enclosing scope must be final or effectively final
		instanceLength = 888; // OK
		return target -> {
			int localLength = target.length();
			instanceLength = 999;   // OK
			return target.toLowerCase()
					+ separator + instanceLength // Error if Line 41 commented out
					+ separator + localLength;
		};
	}
	
	public static void main(String[] args) {
		Demo16_ClosureExample ce = new Demo16_ClosureExample();
		Function<String, String> fn1 = ce.getStringOperation1();
		Function<String, String> fn2 = ce.getStringOperation2();
		Function<String, String> fn3 = ce.getStringOperation3();
		Function<String, String> fn4 = ce.getStringOperation4();
		
		System.out.println(fn1.apply("Aaa"));       // aaa:3:3
		System.out.println(fn2.apply("AaaBbb"));    // aaabbb:7:6
		System.out.println(fn3.apply("AaaBbbCcc")); // aaabbbccc:7:9
		System.out.println(fn4.apply("AaaBbbCcc")); // aaabbbccc:999:9
		
		// fn4 = String::toLowerCase;  // Compilation error if commented out this line:
		                               // Local variable fn4 defined in an enclosing scope 
		                               // must be final or effectively final
		Consumer<String> consumer = t -> fn4.apply(t);
		consumer.accept("xyz");
	}
}
