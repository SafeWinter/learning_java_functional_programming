package ch4.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class Demo15_NonInterface {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        List<Integer> list = getData();
        // Correct version
        printList(new CopyOnWriteArrayList(list));        
        // Error version
        printList(new ArrayList(list));
    }

    private static void printList(List<Integer> hours) {
        Stream<Integer> hoursStream = hours.parallelStream();
        int totalHours = hoursStream.map(h -> {
            int amount = h * 30;
            if (amount > 40) {
                hours.add(h + 10);
            }
            return amount;
        }).reduce(0, (r, s) -> r + s);
        System.out.println(totalHours);
    }
    
    private static List<Integer> getData() {
        return Arrays.asList(32, 40, 54, 23, 35, 48, 40, 40, 23, 54, 45, 
                44, 45, 65, 34, 35, 42, 42, 50, 45, 35, 45, 35, 31, 12, 56);
    }
}
