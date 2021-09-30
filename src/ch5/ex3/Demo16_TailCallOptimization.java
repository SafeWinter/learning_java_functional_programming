package ch5.ex3;

public class Demo16_TailCallOptimization {

	public static void main(String[] args) {
		// Demo1: GCD evaluation
		System.out.println(gcd(48, 72));
		
		// Demo2: factorial without tail call optimization
		System.out.println(fac(5));
		
		// Demo3: factorial with tail call optimization
		System.out.println(facTCO(5));
	}
	
	// wrapper method
	private static long facTCO(long n) {
		return facTOCHelper(n, 1);
	}

	private static long facTOCHelper(long n, long p) {
		return n == 1 ? p : facTOCHelper(n - 1, p * n);
	}

	private static long fac(long n) {
		return n == 1 ? 1 : fac(n - 1) * n;
	}

	private static int gcd(int x, int y) {
		return x % y == 0 ? y : gcd(y, x % y);
	}
	
	/*When to use recursion?
	  - The problem lends itself to a recursive solution
	  - The number of recursive calls are not excessive
	  - Maintainability is important
	*/
}
