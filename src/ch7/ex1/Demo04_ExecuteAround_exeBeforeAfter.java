package ch7.ex1;

import java.util.function.Function;

public class Demo04_ExecuteAround_exeBeforeAfter {

	public static void main(String[] args) {
		Function<Integer, Integer> computeSquare = x -> x * x;
		System.out.println("---executeBefore");
		System.out.println(executeBefore(Demo04_ExecuteAround_exeBeforeAfter::withLog, computeSquare, 5));
		
		System.out.println("---executeAfter");
		System.out.println(executeAfter(computeSquare, Demo04_ExecuteAround_exeBeforeAfter::withLog, 5));
	}
	
	private static int withLog(int value) {
        System.out.print("Operation logged for " + value + " - ");
        return value;
    }

	private static Integer executeBefore(
	    Function<Integer, Integer> before,
	    Function<Integer, Integer> compute,
	    Integer value
	) {
	    before.apply(value);
	    return compute.apply(value);
	}
    
	private static Integer executeAfter(
	    Function<Integer, Integer> compute,
	    Function<Integer, Integer> after,
	    Integer value
	) {
	    Integer result = compute.apply(value);
	    after.apply(result);
	    return result;
	}
}