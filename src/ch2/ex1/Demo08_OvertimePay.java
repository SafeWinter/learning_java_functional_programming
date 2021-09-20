package ch2.ex1;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Demo08_OvertimePay {

	public static void main(String[] args) {
		int hours[] = {8, 12, 8, 6, 6, 5, 6, 0};
		
		// Stream way
		int total = Arrays.stream(hours).sum();
		System.out.println(calculatePay(total, 15.75f, Employee_Type.Hourly));
		
		// FP way		
		BiFunction<int[], Float, Float> payHourly = total <= 40 
				? (hourArray, payRate) -> total * payRate
				: (hourArray, payRate) -> {
					return total * payRate + 1.5f * payRate * (total - 40);
				};
		
		Float result = payHourly.apply(hours, 15.75f);
		System.out.println(result);
	}
	
	
	public static float calculatePay(int hoursWorked, float payRate, Employee_Type type) {
		switch (type) {
			case Hourly:
				return hoursWorked * payRate;
			case Salary:
				return 40 * payRate;
			case Sales:
				return 500.0f + 0.15f * payRate;
			default:
				return 0.0f;
		}
	}
}

enum Employee_Type {
	Hourly,
	Salary,
	Sales
}