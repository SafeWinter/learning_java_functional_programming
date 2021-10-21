package ch8.ex2;

import java.util.Arrays;
import java.util.List;

public class Demo05_Debug_parallel_stream {
	
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");
        list.parallelStream()
            .map(Demo05_Debug_parallel_stream::toLower)
            .forEach(System.out::println);
/*
Thread: Thread[main,5,main] token: Dewey
Dewey-dewey
Thread: Thread[ForkJoinPool.commonPool-worker-5,5,main] token: Louie
Louie-louie
Thread: Thread[ForkJoinPool.commonPool-worker-19,5,main] token: Huey
Huey-huey
*/
    }

    public static String toLower(String token) {
        String lowerCase;
        lowerCase = token + "-" + token.toLowerCase();
        System.out.println("Thread: " + Thread.currentThread() + " token: " + token);
        return lowerCase;
    }
}
