package fp.ch2.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Demo06_FnAsResult {

	public static void main(String[] args) {
		List<String> numberString = Arrays.asList("12", "34", "82");
		List<Integer> numbers = new ArrayList<>();
		List<Integer> doubleNumbers = new ArrayList<>();
		
		// conventional way
		for (String num : numberString) {
			numbers.add(Integer.parseInt(num));
		}
		
		// stream way
		numbers.clear();
		numberString.forEach(
				ns -> numbers.add( Integer.parseInt(ns) ));
		
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
		
		System.out.println(singleFunction.apply(numberString));
		System.out.println(doubleFunction.apply(numberString));
		
		doubleNumbers.clear();
		Arrays.asList(numberString).stream()
			.map(doubleFunction)
			.forEach(System.out::println);
	}
	
}
