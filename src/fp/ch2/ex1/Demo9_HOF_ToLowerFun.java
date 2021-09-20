package fp.ch2.ex1;

import java.util.function.Function;

public class Demo9_HOF_ToLowerFun {

	public static void main(String[] args) {
		System.out.println(square(5));
		
		Function<Integer, Integer> squareFn = x -> x * x;
		
		System.out.println(squareFn.apply(6));
	}
	
	public static int square(int x) {
		return x * x;
	}
}
