package ch2.ex1;

import java.util.function.Function;

public class Demo10_PureFunction {

	private static int square(int x) {
		return x * x;
	}
	
	public static void main(String[] args) {

		// Traditional method way
		System.out.println(square(5));
		
		// Lambda expression way
		Function<Integer, Integer> squareFn = x -> x * x;
		System.out.println(squareFn.apply(6));
	}
	
}
