package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;

public class Demo15_Monad_LeftIdentity {
	
	// Left identity means that the value within a monad can be transformed within the monad. 
	// That is, it is not necessary to remove an object from a monad, transform it, and then 
	// place it back into a monad.
	public static void main(String[] args) {
		
		Function<? super String, Optional<String>> toConcatString = x -> Optional.of(x + "ing");
		Function<? super String, Optional<String>> toUpperString = x -> Optional.of(x.toUpperCase());
		Optional<String> ostring = Optional.of("go");

		
		// Conventional way
		Optional<String> monad1;
		Optional<String> result;
		monad1 = ostring.flatMap(toConcatString);
		result = toUpperString.apply(monad1.get());
		System.out.println(result + " " + result.get());
		
		
		// Monad way: invoke operations without extracting a monad value.
		result = ostring
				.flatMap(toConcatString)
				.flatMap(toUpperString);
		System.out.println(result + " " + result.get());
	}
}
