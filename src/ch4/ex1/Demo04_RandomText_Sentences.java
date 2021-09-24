package ch4.ex1;

import java.util.Random;
import java.util.stream.Stream;

public class Demo04_RandomText_Sentences {
	
	private static String[] subject = {"cat", "dog", "monkey", "bat"};
	private static String[] verb = {"chased", "ate", "lost", "swatted"};
	private static String[] object = {"ball", "rat", "doughnut", "tamale"};
	
	public static void main(String[] args) {
		
		randomSentences();
		
		System.out.println();
		
		randomSentencesWithSeed();
	}

	private static void randomSentencesWithSeed() {
	    
	    Random random = new Random();
	    
	    String seed = String.format("%s %s the %s", 
	    		subject[random.nextInt(3)], 
	    		verb[random.nextInt(3)],
	    		object[random.nextInt(3)]);
	    
	    Stream.iterate(seed, s -> String.format("%s %s the %s", 
	    		subject[random.nextInt(3)], 
	    		verb[random.nextInt(3)],
	    		object[random.nextInt(3)])
	    	)
	    	.limit(5)
	    	.forEach(System.out::println);
	}

	private static void randomSentences() {
	    
	    Random random = new Random();
	    
	    Stream.iterate("", s -> String.format("%s %s the %s", 
	    		subject[random.nextInt(3)], 
	    		verb[random.nextInt(3)],
	    		object[random.nextInt(3)])
	    	)
	    	.limit(5)
	    	.forEach(System.out::println);
	}
}
