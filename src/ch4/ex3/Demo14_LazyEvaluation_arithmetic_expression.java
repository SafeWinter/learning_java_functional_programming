package ch4.ex3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo14_LazyEvaluation_arithmetic_expression {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void main(String[] args) {
        
        Function<Integer, Integer> divBy0 = n -> 1 / 0;
        Function<Integer, Integer> multi5 = n -> n * 5;
        Function<Integer, Integer> add3   = n -> n + 3;
        Function<Integer, Integer> minus4 = n -> n - 4;
        
        Function[] arr = {divBy0, multi5, add3, minus4};
        Stream<Function> stream = Arrays.stream(arr);
        stream.skip(1)
            .forEach(operation -> System.out.println(operation.apply(2)));
    }
}
