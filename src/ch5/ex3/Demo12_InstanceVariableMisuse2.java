package ch5.ex3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo12_InstanceVariableMisuse2 {
    
    public static void main(String[] args) {
		int indexTop5 = 4;
		int myTotal = new Demo12_InstanceVariableMisuse2()
				.arrayTotal(getArray(), indexTop5);
		System.out.println("Sum of top" + (indexTop5 + 1) + ": " + myTotal);
	}
    
	// Correct version: remove redundant instance variable
    public int arrayTotal(int numbers[], int index) {
        if (index == 0) {
            return numbers[0];
        } else {
            return numbers[index] + arrayTotal(numbers, index - 1);
        }
    }

	private static int[] getArray() {
		int[] arr = IntStream.range(2, 11).toArray();
		System.out.printf("Array: ");
		Arrays.stream(arr).forEach(n -> System.out.printf("%d ", n));
		System.out.println();
		return arr;
	}
}
