package ch2.ex2;

public class Demo19_TypeInference {
	
	public static void main(String[] args) {
		
		StringConcatenation  sc = (s, t) -> s + ":" + t;
		IntegerConcatenation ic = (m, n) -> m + ":" + n;
		DoubleConcatenation  dc = (m, n) -> m + ":" + n;

		System.out.println(sc.concatenate("Cat", "Dog"));
		System.out.println(ic.concatenate(23, 45));
		System.out.println(dc.concatenate(23.12, 45.12));
		
		System.out.println();
		
		Concatenation<String>  sc1 = (s, t) -> s + ":" + t;
		Concatenation<Integer> ic1 = (m, n) -> m + ":" + n;
		Concatenation<Double>  dc1 = (m, n) -> m + ":" + n;
		
		System.out.println(sc1.concatenate("Cat", "Dog"));
		System.out.println(ic1.concatenate(23, 45));
		System.out.println(dc1.concatenate(23.12, 45.12));
	}
	
}

interface StringConcatenation {
	String concatenate(String s1, String s2);
}

interface IntegerConcatenation {
	String concatenate(Integer n1, Integer n2);
}

interface DoubleConcatenation {
	String concatenate(Double n1, Double n2);
}

interface Concatenation<T> {
	String concatenate(T u, T v);
}