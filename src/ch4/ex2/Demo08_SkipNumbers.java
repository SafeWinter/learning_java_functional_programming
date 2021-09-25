package ch4.ex2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Demo08_SkipNumbers {

    public static void main(String[] args) {
        int[] numbers = {3, 6, 8, 8, 4, 6, 3, 3, 5, 6, 9, 4, 3, 6};
        
        IntSummaryStatistics status = Arrays
                .stream(numbers)
                .skip(5)
                .summaryStatistics();
        System.out.printf("Average: %.1f\nCount: %d\nMin: %d\nMax: %d\nSum: %d", 
                status.getAverage(), status.getCount(), status.getMin(), status.getMax(), status.getSum());
        /*
        Average: 5.0
        Count: 9
        Min: 3
        Max: 9
        Sum: 45
        */
    }
}