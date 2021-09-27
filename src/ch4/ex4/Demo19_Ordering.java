package ch4.ex4;

import java.util.Arrays;
import java.util.List;

public class Demo19_Ordering {
    
    public static void main(String[] args) {
        List<Integer> hours = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 54, 35, 
                34, 25, 15, 34, 35, 42, 44, 40, 35, 35, 45, 35, 31, 12, 56, 31, 12, 56);

        // Error one
        hours.parallelStream()
            .filter(h -> h > 40)
            .sorted()
            .forEach(h -> System.out.printf("%d ", h));
        System.out.println();
        
        // Correct one
        hours.parallelStream()
        .filter(h -> h > 40)
        .sorted()
        .forEachOrdered(h -> System.out.printf("%d ", h));
        System.out.println();
    }
}
