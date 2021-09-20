package ch2.ex1;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Demo07_CalculatePay {

	public static void main(String[] args) {
		int hoursWorked[] = {8, 12, 8, 6, 6, 5, 6, 0};
		
		// Tranditional way
		int total = 0;
		for (int hour : hoursWorked) {
			total += hour;
		}
		System.out.println(calculatePay(total, 15.75f, EmployeeType.Hourly));
		
		// Stream way
		int total1 = Arrays.stream(hoursWorked).sum();
		System.out.println(calculatePay(total1, 15.75f, EmployeeType.Hourly));
		
		// FP way
		BiFunction<int[], Float, Float> payHourly = calculate(EmployeeType.Hourly);
		Float pay = payHourly.apply(hoursWorked, 15.75f);
		System.out.println(pay);
	}
	
	private static BiFunction<int[], Float, Float> calculate(EmployeeType type) {
		switch (type) {
			case Hourly: 
				return (hours, rate) -> Arrays.stream(hours).sum() * rate;
			case Salary: 
				return (hours, rate) -> 40 * rate;
			case Sales: 
				return (hours, rate) -> 500.0f + 0.15f * rate;
			default: 
				return null;
		}
	}
	
	public static float calculatePay(int hoursWorked, float payRate, EmployeeType type) {
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

enum EmployeeType {
	Hourly,
	Salary,
	Sales
}