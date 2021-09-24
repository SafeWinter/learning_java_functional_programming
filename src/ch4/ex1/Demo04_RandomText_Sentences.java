package ch4.ex1;

import java.util.Random;
import java.util.stream.Stream;

public class Demo04_RandomText_Sentences {
	
	public static void main(String[] args) {
		
		randomSentences();
		
		System.out.println();
		
		randomSentencesWithSeed();
	}

	private static void randomSentencesWithSeed() {
		String[] subject = {"cat", "dog", "monkey", "bat"};
	    String[] verb = {"chased", "ate", "lost", "swatted"};
	    String[] object = {"ball", "rat", "doughnut", "tamale"};
	    
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
		String[] subject = {"cat", "dog", "monkey", "bat"};
	    String[] verb = {"chased", "ate", "lost", "swatted"};
	    String[] object = {"ball", "rat", "doughnut", "tamale"};
	    
	    Random random = new Random();
	    
	    String seed = "";
	    Stream.iterate(seed, s -> String.format("%s %s the %s", 
	    		subject[random.nextInt(3)], 
	    		verb[random.nextInt(3)],
	    		object[random.nextInt(3)])
	    	)
	    	.limit(5)
	    	.forEach(System.out::println);
	}
}
