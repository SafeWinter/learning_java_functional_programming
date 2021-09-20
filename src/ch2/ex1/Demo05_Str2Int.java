package ch2.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Demo05_Str2Int {

	public static void main(String[] args) {
		List<String> numberString = Arrays.asList("12", "34", "82");
		List<Integer> numbers = new ArrayList<>();
		List<Integer> doubleNumbers = new ArrayList<>();
		
		// Conventional way
		for (String num : numberString) {
			numbers.add(Integer.parseInt(num));
		}
		
		// Stream way
		numbers.clear();
		numberString.forEach(
				ns -> numbers.add(Integer.parseInt(ns)));
		
		numbers.clear();
		Function<List<String>, List<Integer>> singleFunction = s -> {
			s.forEach(t -> numbers.add(Integer.parseInt(t)));
			return numbers;
		};
		
		doubleNumbers.clear();
		Function<List<String>, List<Integer>> doubleFunction = d -> {
			d.forEach(e -> 
				doubleNumbers.add(Integer.parseInt(e) * 2));
			return doubleNumbers;
		};
		
		// Invocation
		System.out.println(singleFunction.apply(numberString));
		System.out.println(doubleFunction.apply(numberString));
		
		
		// Pass a function to a method
		doubleNumbers.clear();
		Arrays.asList(numberString).stream()
			.map(doubleFunction)
			.forEach(System.out::println);;
	}
	
}
