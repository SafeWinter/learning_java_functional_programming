package ch3.ex1;

import java.util.function.Function;

public class Demo03_andThen {

    public static void main(String[] args) {
        Function<Integer, Integer> plusTwo = x -> 2 + x;
        Function<Integer, Integer> byThree = x -> x * 3;
        Function<Integer, Integer> f = plusTwo.andThen(byThree);  // f(x) = (2 + x) * 3
        Function<Integer, Integer> g = byThree.andThen(plusTwo);  // g(x) = 2 + (x * 3)
        
        System.out.println(f.apply(5));  // 21
        System.out.println(g.apply(5));  // 17
    }    
    
}
