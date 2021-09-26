package ch4.ex3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo16_StatelessOperation {

    private static int rate = 30;
    
    public static int getPay(int hours) {
        if (hours > 40) {
            rate = 25;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                // Handle exception
            }
        } else {
            rate = 30;
        }
        return rate * hours;
    }
    
    public static void main(String[] args) {
        List<Integer> hours = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 
                54, 35, 34, 25, 15, 34, 35, 42, 44, 40, 35, 
                35, 45, 35, 31, 12, 56); 
        Stream<Integer> hoursStream;
        for(int i=0; i<2; i++) {
            rate = 30;
            int total = hours
                    .parallelStream()
                    .map(h -> getPay(h))
                    .reduce(0, (r, s) -> r + s);
            System.out.println(total);
        }
    }

}
