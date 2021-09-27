package ch5.ex1;

public class Demo01_DirectRecursion_factorial {

    public static void main(String[] args) {
        // Iterative approach
        long fact = 1;
        for(int i = 1; i <= 5; i++) {
            fact *= i;
        }
        System.out.printf("fact: %d\n", fact);
        
        // Recursive approach
        long factNew = factorial(5);
        System.out.printf("fact: %d\n", factNew);
    }

    private static long factorial(int n) {
        if(n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
