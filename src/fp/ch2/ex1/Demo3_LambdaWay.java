package fp.ch2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo3_LambdaWay {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		
		list.forEach(System.out::println);
		
		list.forEach(s -> System.out.println(s));
		
		Consumer<String> consumer = t -> System.out.println(t);
		list.forEach(consumer);
	}
}
