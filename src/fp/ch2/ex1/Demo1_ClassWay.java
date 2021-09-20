package fp.ch2.ex1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Demo1_ClassWay {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Huey", "Duey", "Luey");
		list.forEach(new ConsumerImpl<>());
	}
}

class ConsumerImpl<T> implements Consumer<T> {
	@Override
	public void accept(T t) {
		System.out.println(t);
	}
}