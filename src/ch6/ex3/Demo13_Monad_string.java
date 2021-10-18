package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;

public class Demo13_Monad_string {
	public static void main(String[] args) {
		Function<? super String, Optional<String>> toConcatString = x -> Optional.of(x + "ing");
		Function<? super String, Optional<String>> toUpperString = x -> Optional.of(x.toUpperCase());
		
		// execution order not interchangeable
		Optional<String> ostring = Optional.of("go");
		Optional<String> result = ostring
			.flatMap(toConcatString)
			.flatMap(toUpperString);
			
		System.out.println(ostring.get());  // go
		System.out.println(result.get());  // GOING
	}
}
