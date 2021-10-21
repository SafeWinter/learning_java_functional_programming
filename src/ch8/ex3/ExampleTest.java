package ch8.ex3;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

import org.junit.Test;

public class ExampleTest {
    
    @Test
    public void testSomething() {
        // Code to be tested
        int resultValue = 12;
        int actual = 6 * 2;
        
        // Original
        assertThat("Not equal to " + resultValue, actual, equalTo(resultValue));
        
        // Newer version
        assertEquals("Not equal to " + resultValue, resultValue, actual);
        
    }
    
    
    // Copying the lambda expression
    Function<Integer, Integer> function = n -> 
        (n % 2 == 0) 
            ? n * 2 
            : n * n;
    @Test
    public void testEven() {
        int result = function.apply(22);
        assertThat("Not even", result, equalTo(44));
    }
    @Test
    public void testOdd() {
        int result = function.apply(3);
        assertThat("Not odd", result, equalTo(9));
    }
    
    
    // Using a method reference
    public static int processNumber(int number) {
        if (number % 2 == 0) {
            return number * 2;
        } else {
            return number * number;
        }
    }
    @Test
    public void testMethodReference() {
        IntStream stream = IntStream.of(3, 15, 16, 12, 3);
        int result = stream
                .map(ExampleTest::processNumber)
                .sum();
        assertThat("Bad", result, equalTo(299));
    }
    
    
    // Reorganizing the test class: stream as parameter
    public int computeSum(IntStream stream) {
        int result = stream
                .map(ExampleTest::processNumber)
                .sum();
        return result;
    }
    @Test
    public void testPositiveNumbers() {
        IntStream stream = IntStream.of(3, 15, 16, 12, 3);
        int result = computeSum(stream);
        assertThat("Positive number failure", result, equalTo(299));
    }
    @Test
    public void testNegativeNumbers() {
        IntStream stream = IntStream.of(-4, -13, -16, -2, -3);
        int result = computeSum(stream);
        assertThat("Negative number failure", result, equalTo(134));
    }
    
    
    // Different lambda expression applied to the same collection stream
    public int testLambdaExpression(IntUnaryOperator function) {
        IntStream stream = IntStream.of(3, 15, 16, 12, 3);
        int result = stream
                .map(n -> function.applyAsInt(n))
                .sum();
        return result;
    }
    @Test
    public void testDouble() {
        int result = testLambdaExpression(n -> 2 * n);
        assertThat("Bad double results", result, equalTo(98));
    }
    @Test
    public void testSquare() {
        int result = testLambdaExpression(n -> n * n);
        assertThat("Bad square results", result, equalTo(643));
    }

    
    // Pass stream and lambda expression as parameters
    public int testAll(IntStream stream, IntUnaryOperator function) {
        int result = stream
                .map(n -> function.applyAsInt(n))
                .sum();
        return result;
    }
    @Test
    public void testStreamAndLE() {
        IntStream stream = IntStream.of(3, 15, 16, 12, 3);
        int result = testAll(stream, n -> 2 * n);
        assertThat("Bad results", result, equalTo(98));
    }
}
