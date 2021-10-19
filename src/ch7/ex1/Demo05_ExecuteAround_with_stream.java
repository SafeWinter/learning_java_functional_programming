package ch7.ex1;

import java.util.Arrays;
import java.util.function.Function;

public class Demo05_ExecuteAround_with_stream {

public static void main(String[] args) {
		
	    Function<Integer, Integer> computeSquare = n -> n * n;
	    Function<Integer, Integer> computeDuration = x -> executeDuration(computeSquare, x);
	            
	    Integer[] arr = {1, 2, 3, 4, 5};
	    Arrays.stream(arr)
	        .map(computeDuration)
//	        .map(x->executeDuration(computeSquare, x))
	        .forEach(System.out::println);
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