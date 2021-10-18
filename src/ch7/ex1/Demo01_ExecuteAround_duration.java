package ch7.ex1;

import java.util.function.Function;

public class Demo01_ExecuteAround_duration {

	public static void main(String[] args) {
		
		System.out.println(imperativeSquareApproach(5));
		System.out.println(imperativeCubeApproach(5));
		
		Function<Integer, Integer> computeSquare = x -> x * x;
		Function<Integer, Integer> computeCube = x -> x * x * x;
		System.out.println(functionalApproach(computeSquare, 5));
		System.out.println(functionalApproach(computeCube, 5));
	}
	
	// imperative
	public static int imperativeSquareApproach(int value) {
		long start = System.currentTimeMillis();
		int result = 0;
		try {
			result = value * value;
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.print("Duration: " + duration + " - ");
		return result;
    }
	public static int imperativeCubeApproach(int value) {
		long start = System.currentTimeMillis();
		int result = 0;
		try {
			result = value * value * value;
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.print("Duration: " + duration + " - ");
		return result;
    }
	
	// functional
	public static int functionalApproach(Function<Integer, Integer> computation, int value) {
		long start = System.currentTimeMillis();
		Integer result = null;
		try {
			result = computation.apply(value);
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long duration = end - start;
		System.out.print("Duration: " + duration + " - ");
		return result;
	}
}
