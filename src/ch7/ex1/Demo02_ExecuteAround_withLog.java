package ch7.ex1;

import java.util.function.Function;

public class Demo02_ExecuteAround_withLog {

	public static void main(String[] args) {
		
		Function<Integer, Integer> computeSquare = x -> x * x;
	    System.out.println(executeWithLog(computeSquare, 5));
	    System.out.println(executeWithLog(x -> x * x, 5));
	    
	    System.out.println(withLog(5));
	}
	
	private static int withLog(int value) {
        System.out.print("Operation logged for " + value + " - ");
        return value;
    }

    private static int executeWithLog(Function<Integer, Integer> fn, int value) {
        System.out.print("Operation logged for " + value + " - ");
        return fn.apply(value);
    }
	
}