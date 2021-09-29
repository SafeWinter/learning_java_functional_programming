package ch5.ex3;

import java.util.stream.IntStream;

public class Demo14_WrapperMethod {
    
    public static void main(String[] args) {
        // A wrapper method will not actually perform recursion but will call one that does
        int[] numbers = IntStream.range(2, 11).toArray();
        int sum = arrayTotal(numbers, 4);
        System.out.println(sum);
        
        sum = arrayTotalHelper(numbers, 10);
        System.out.println(sum);
    }
    
    private static int arrayTotalHelper(int[] numbers, int index) {
        if(index >= 0 && index < numbers.length) {
            return arrayTotal(numbers, index);
        } else {
            // Handle exception
            System.err.println("Invalid index: " + index);
            return -1;
        }
    }
    
    private static int arrayTotal(int[] numbers, int index) {
        if(index == 0) {
            return numbers[index];
        } else {
            return numbers[index] + arrayTotal(numbers, index - 1);
        }
    }

}
