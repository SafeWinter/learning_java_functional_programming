package ch3.ex1;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Demo07_FluentInterfaces {

    public static void main(String[] args) {
        int[] hoursWorked = {8, 12, 8, 6, 6, 5, 6, 0};
        int totalHoursWorked = Arrays.stream(hoursWorked)
            .filter(n -> n > 6)
            .sum();
        System.out.println(totalHoursWorked);  // 28
        
        LocalDateTime timeInstance = LocalDateTime.now()
            .plusDays(3)
            .minusHours(4)
            .plusWeeks(1)
            .plusYears(2);
        System.out.println(timeInstance);  // 2023-10-01T15:30:47.043349200
    }
    
}
