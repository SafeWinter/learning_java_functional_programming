package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;

public class Demo16_Monad_RightIdentity {
	
	// The right identity law supports the chaining behavior of monads. One way of 
	// stating this law is the application of the unit function against a monad has 
	// the same effect as if the unit function was never applied.
	public static void main(String[] args) {
		
		Optional<String> ostring = Optional.of("right");

		System.out.println(
			ostring.flatMap(s -> Optional.of(s)) == ostring       // test of equality operator: false 
		);
		
		System.out.println(
			ostring.flatMap(s -> Optional.of(s)).equals(ostring)  // test of equals method: true
		);
		
		System.out.println(
			ostring.flatMap(s -> Optional.of(s)) + "==" + ostring // test of result & variable: the same
		);
	}
}
