package ch4.ex4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo17_SideEffect_ArrayList {
    
    public static void main(String[] args) {
        List<Integer> hours = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 54, 35, 
                34, 25, 15, 34, 35, 42, 44, 40, 35, 35, 45, 35, 31, 12, 56, 31, 12, 56);

        for(int i = 0; i < 50; i++) {
            List<Integer> overtimeList = new ArrayList<>();
            hours.parallelStream()
                .filter(h -> h > 40)
                .forEach(h -> overtimeList.add(h));
            
            for (Integer h : overtimeList) {
                System.out.print(h + " ");
            }
            System.out.println();
        }
        
        // ArrayList is not thread safe
        // null values may creep in or an ArrayIndexOutOfBoundsException exception may be generated
    }
}
