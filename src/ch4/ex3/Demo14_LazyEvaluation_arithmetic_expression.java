package ch4.ex3;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public class Demo14_LazyEvaluation_arithmetic_expression {

    public static void main(String[] args) {
        Function<Integer,Integer> divide = n->1/0;
        Function<Integer,Integer> add = n->n+3;
        Function<Integer,Integer> multiply = n->n*5;
        Function<Integer,Integer> subtract = n->n-4;
        
        Function[] arr = {divide,add,multiply,subtract};
        Stream<Function> stream = Arrays.stream(arr);
        stream.skip(1)
        .forEach(operation -> System.out.println(operation.apply(2)));
    }
}
