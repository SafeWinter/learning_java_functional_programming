package ch2.ex2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo13_EliminatingDependencies {
	
	public static void main(String[] args) {
		BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
		Function<Double, Double>            computeSalary = rate -> rate * 40.0f;
		BiFunction<Double, Double, Double>  computeSales  = (rate, commission) -> rate * 40.0f + commission;
		
		System.out.println(computeHourly.apply(35, 12.75)
				+ computeSalary.apply(25.35)
				+ computeSales.apply(8.75, 2500.0)
		);
	}
}
