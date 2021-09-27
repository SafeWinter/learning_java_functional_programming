package ch4.ex4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo18_SideEffect_collect {
    
    public static void main(String[] args) {
        List<Integer> hours = Arrays.asList(32, 40, 24, 23, 35, 18, 40, 30, 23, 54, 35, 
                34, 25, 15, 34, 35, 42, 44, 40, 35, 35, 45, 35, 31, 12, 56, 31, 12, 56);

        // The correct version: use collect
        for(int i = 0; i < 50; i++) {
            List<Integer> overtimeList = hours.parallelStream()
                .filter(h -> h > 40)
                .collect(Collectors.toList());
            
            overtimeList.stream().forEach(h -> System.out.print(h + " "));
            System.out.println();
        }
        
    }
}
