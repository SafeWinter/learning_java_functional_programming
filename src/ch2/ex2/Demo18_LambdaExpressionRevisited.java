package ch2.ex2;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class Demo18_LambdaExpressionRevisited {
	
	public static void main(String[] args) {
		
		Function<Integer, Integer> demo1;
		
		demo1 = x -> x + 1;
				
		demo1 = (x) -> x + 1;
		
		demo1 = (Integer x) -> x + 1;

		demo1 = x -> {
		    x = x + 1;
		    return x;
		};
		
		demo1 = x -> {
			Integer y;
			y = x + 1;
			return y;
		};
		
		
		BiFunction<Integer, Integer, Integer> demo2;
		
		demo2 = (x, y) -> x + y;
		
		demo2 = (Integer x, Integer y) -> x + y;
		
		
		BiConsumer<Integer, Integer> demo3;
		
		demo3 = (x, y) -> System.out.println(x + y);
		
		

	}
}
