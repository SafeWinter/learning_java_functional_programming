package ch2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo02_InnerClassWay {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String s) {
				System.out.println(s);
			}
		});
	}
}
