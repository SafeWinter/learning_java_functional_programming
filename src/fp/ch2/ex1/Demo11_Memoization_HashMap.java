package fp.ch2.ex1;

import java.util.HashMap;
import java.util.Map;

public class Demo11_Memoization_HashMap {

	private static final Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	
	private static Integer doComputeExpensiveSquare(Integer input) {
		System.out.println("Compute square.");
		return 2 * input;
	}
	
	private static Integer computeExpensiveSquare(Integer input) {
		if(!cache.containsKey(input)) {
			cache.put(input, doComputeExpensiveSquare(input));
		}
		return cache.get(input);
	}
	
	public static void main(String[] args) {
		System.out.println(computeExpensiveSquare(4));
		System.out.println(computeExpensiveSquare(4));
	}
}
