package ch4.ex3;

import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class Demo13_LazyEvaluation_numbers {

    public static void main(String[] args) {
        IntUnaryOperator sampleMap = num -> {
            System.out.println("number: " + num);
            return num;
        };
        Random random = new Random();
        IntStream randomStream = random.ints()
                .limit(5)
                .map(sampleMap)
                .sorted();
        System.out.println(randomStream);
        randomStream.forEach(System.out::println);
    }
}
