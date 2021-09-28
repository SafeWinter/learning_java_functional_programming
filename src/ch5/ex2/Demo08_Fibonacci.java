package ch5.ex2;

public class Demo08_Fibonacci {

    public static void main(String[] args) {
        
        // Recursive:
        System.out.println(fib(11));

        
        // Iterative:
        int[] fib = new int[12];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2, len = fib.length; i < len; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[11]);

        
        // Improved iterative way
        System.out.println(fibonacciDP(11));
        
        // TODO Improved recursive way: using memoization
    }

    private static long fib(int n) {
        // return n < 3 ? 1 : fib(n - 1) + fib(n - 2);
        return (n == 0 || n == 1) ? n : fib(n - 1) + fib(n - 2);
    }

    /**
     * Improved version.<br/>
     * from:Jose Ordiales, Dynamic Programming - Introduction<br/>
     * https://jlordiales.me/posts/2014/02/dynamic-programming-introduction/
     */
    public static long fibonacciDP(int n) {
        long n1 = 1;
        long n2 = 1;
        long current = 1;
        for (int i = 3; i <= n; i++) {
            current = n1 + n2;
            n2 = n1;
            n1 = current;
        }
        return current;
    }

}