package ch5.ex2;

public class Demo09_ConvertIterativeLoop {

    public static void main(String[] args) {
        // original
        int sum = 0;
        for(int i = 2; i <= 20; i+=2) {
            sum += i;
        }
        System.out.println(sum);  // 110
        
        // Convert to recursion
        sum = recursiveSum(20);
        System.out.println(sum);  // 110
    }

    // Warning: only valid for even numbers greater than or equal to 2
    private static int recursiveSum(int n) {
        if(n == 2) {
            return 2;
        } else {
            return n + recursiveSum(n - 2);
        }
        
    }
}
