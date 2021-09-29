package ch5.ex3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Demo13_StaticVariableMisuse {

	public static int total = 0;

	public static void main(String[] args) {
		int indexTop = 4;
		int myTotal = new Demo13_StaticVariableMisuse()
				.arrayTotal(getArray(), indexTop);
		System.out.println("Sum of top" + (indexTop + 1) + ": " + myTotal);
	}
    
	// Wrong version: misuse of static variable total
	@SuppressWarnings("unused")
	public int arrayTotal(int numbers[], int index) {
		int total = 0;
        if (index == 0) {
            return numbers[0];
        } else {
            total += numbers[index];
            return arrayTotal(numbers, index - 1);
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
