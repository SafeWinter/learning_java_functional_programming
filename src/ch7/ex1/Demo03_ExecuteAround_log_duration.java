package ch7.ex1;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

public class Demo03_ExecuteAround_log_duration {

	// Duration + withLog
	public static void main(String[] args) {
		
		final int value = 5;
		
		// Log & execute in one function
	    Function<Integer, Integer> computeSquare = n -> n * n;
	    System.out.println(executeWithLog(computeSquare, value));
	    System.out.println();
	    
	    // Duration + log
	    int result = executeDuration(x -> x * x, value);
	    System.out.println(withLog(result));
	    System.out.println();
	    
	    // Composition: log + duration & duration + log
	    System.out.println(withLog(executeDuration(x -> x * x, value)));
	    System.out.println(executeDuration(x -> x * x, withLog(value)));
	}
	
	private static int withLog(int value) {
        System.out.print("Operation logged for " + value + " - ");
        return value;
    }
	
	private static int executeWithLog(Function<Integer, Integer> consumer, int value) {
		System.out.print("Operation logged for " + value + " - ");
		return consumer.apply(value);
	}
	
    public static int executeDuration(Function<Integer, Integer> computation, int value) {
        long start = System.currentTimeMillis();
        int result = 0;
        try {
            result = computation.apply(value);
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long duration = end - start;
        System.out.print("Duration: " + duration + " - ");
        return result;
    }
}