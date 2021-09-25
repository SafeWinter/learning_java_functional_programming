package ch4.ex2;

import java.util.Arrays;
import java.util.function.IntConsumer;

public class Demo09_SortNumbers {

    public static void main(String[] args) {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
        
        IntConsumer listNumbers = n -> System.out.print(n + " ");
        // Sort in ascending order (default)
        Arrays.stream(numbers).sorted().forEach(listNumbers);

        System.out.println();
        
        // Sort + distinct
        Arrays.stream(numbers).sorted().distinct().forEach(listNumbers);
    }
}