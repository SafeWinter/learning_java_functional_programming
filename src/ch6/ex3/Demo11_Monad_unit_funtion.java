package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;

public class Demo11_Monad_unit_funtion {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        // Understanding context
        Optional<Integer> one = Optional.of(1);
        Optional<String> ostring = Optional.of("go");

        
        // Using of method as unit function
        System.out.println(one.flatMap(n -> Optional.of(n + 1)).get());

        
        // Declare a variable to hold the lambda expression
        Function<? super Integer, Optional<? super Integer>> plusOneFunction =
                n -> Optional.of(n + 1);
        Optional<Object> plusOne = one.flatMap(plusOneFunction);
        System.out.println(plusOne.get());
    }
}
