package ch2.ex2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo17_Currying {
	
	public static void main(String[] args) {
		BiFunction<String, String, String> fn = (a, b) -> a + b;
		System.out.println(fn.apply("Cat", "Dog"));  // CatDog
		
		Function<String, Function<String, String>> intermediateFunction;
		intermediateFunction = a -> b -> fn.apply(a, b);
		
		Function<String, String> curryCatFn = intermediateFunction.apply("Cat ");
		System.out.println(curryCatFn);
		
		System.out.println(curryCatFn.apply("Dog"));
		
		//----------------
		
		Function<Double, Function<Double, Double>> curryAdd = a -> b -> a + b;
		Function<Double, Double> plus3 = curryAdd.apply(3.0d);
		Double result = plus3.apply(4.0d);
		System.out.println(result);  // 7.0
	}
}
