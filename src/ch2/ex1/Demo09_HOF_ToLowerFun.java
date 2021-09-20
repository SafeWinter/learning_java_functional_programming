package ch2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo09_HOF_ToLowerFun {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		
		Function<String,String> toLowerFunction = String::toLowerCase;
	    Consumer<String> consumer = s -> System.out.println(toLowerFunction.apply(s));
	    list.forEach(s -> consumer.accept(s));
	}
}
