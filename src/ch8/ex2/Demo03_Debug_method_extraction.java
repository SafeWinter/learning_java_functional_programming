package ch8.ex2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo03_Debug_method_extraction {
	
    public static void main(String[] args) {
    	
    	// Original version:
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");
        list.stream().map(s -> s + "-" + s.toLowerCase())
        		.forEach(s -> System.out.println(s));
        
        System.out.println();
        
        // Method extraction:
        list.stream()
        	.map(Demo03_Debug_method_extraction::toLower)
        	.forEach(System.out::println);
    }
    
    private static String toLower(String token) {
    	String lowerCase;
    	lowerCase = token + "-" + token.toLowerCase();
    	return lowerCase;
    }
}
