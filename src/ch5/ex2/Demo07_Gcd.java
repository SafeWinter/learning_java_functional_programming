package ch5.ex2;

public class Demo07_Gcd {

    public static void main(String[] args) {
        // GCD: Greatest Common Denominator
        System.out.println(gcd(48, 72));
        System.out.println(gcd(182, 154));
    }

    private static int gcd(int x, int y) {        
        return x % y == 0 ? y : gcd(y, x % y);
    }
    
}