package fp.ch2.ex2;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo14_LazyEvaluation {
	
	public static void main(String[] args) {
		BiFunction<Integer, Double, Double> computeHourly = (hours, rate) -> hours * rate;
		Function<Double, Double>            computeSalary = rate -> rate * 40.0f;
		BiFunction<Double, Double, Double>  computeSales  = (rate, commission) -> rate * 40.0f + commission;
		
		double hourlyPay = computeHourly.apply(35, 12.75);
		double salaryPay = computeSalary.apply(25.35);
		double salesPay  = computeSales.apply(8.75, 2500.0);
		
	    boolean hourly = true; // some logics
	    double total = hourly 
	    		? hourlyPay 
	    		: salaryPay + salesPay;
	    
	    System.out.println(total);
	}
}
