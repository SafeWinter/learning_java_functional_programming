package ch3.ex1;

import java.util.function.Function;

public class Demo02_Java8Compose {

    public static void main(String[] args) {
        Function<Double, Double> by2 = d -> d * 2;
        Function<Double, Double> negate = d -> -d;
        Function<Double, Double> composeFn1 = by2.andThen(negate);
        Function<Double, Double> composeFn2 = negate.compose(by2);
        
        System.out.println(composeFn1.apply(5d));  // -10.0
        System.out.println(composeFn2.apply(5d));  // -10.0
    }    
    
}
