package ch4.ex1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo01_ImperativeVsFunctional {
	
	public static void main(String[] args) {
		
		int[] numbers = {3,6,8,8,4,6,3,3,5,6,9,4,3,6};
		
		// Imperative way
		HashSet<Integer> numberSet = new HashSet<>();
		for (int number : numbers) {
			numberSet.add(number);
		}
		int total = 0;
		for (Integer number : numberSet) {
			total += number;
		}
		System.out.println(total);
		
		// Functional way
		total = IntStream.of(numbers).distinct().sum();
		System.out.println(total);
		
		total = Arrays.stream(numbers).distinct().sum();
		System.out.println(total);
	}
}
