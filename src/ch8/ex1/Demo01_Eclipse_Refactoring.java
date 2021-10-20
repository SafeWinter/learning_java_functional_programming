package ch8.ex1;

import java.util.Arrays;
import java.util.List;

public class Demo01_Eclipse_Refactoring {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");
        list.forEach(System.out::println);
    }
}
