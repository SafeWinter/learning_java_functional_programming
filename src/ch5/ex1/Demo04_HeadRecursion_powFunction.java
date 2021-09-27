package ch5.ex1;

public class Demo04_HeadRecursion_powFunction {

    public static void main(String[] args) {
        // $5.2.2 Using head recursion: Power function example
        System.out.println(pow(9, 5));
    }

    private static long pow(long base, long exponent) {
        if(exponent == 0) { return 1; }
        
        if(exponent == 1) { return base; }
        
        long temp = pow(base, exponent / 2);
        return exponent % 2 == 0
                ? temp * temp
                : temp * temp * base;
    }

}