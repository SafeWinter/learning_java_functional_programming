package fp.ch2.ex2;

import java.util.function.Function;

public class Demo15_ReferentialTransparency {
	
	public static void main(String[] args) {
		// Demo1: pure function
		Function<Double, Double> pureFn = t -> 3 * t;
		
		// Demo: impure function
		// Compiling error in Line 16: Local variable num defined in 
		//   an enclosing scope must be final or effectively final
//		int num = 5;
//		num = 6;
//		Function<Double, Double> impureFn = t -> num * t;  
	}
}
