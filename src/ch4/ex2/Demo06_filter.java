package ch4.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo06_filter {

    public static void main(String[] args) {
        String[] animals = {"cats", "dog", "ox", "bats", "horses", "mule"};
        // Conventional way
        List<String> list = new ArrayList<>();
        for (String animal : animals) {
            if(!animal.matches(".*s$")) {
                list.add(animal);
            }
        }
        list.sort(null);
        for (String name : list) {
            System.out.println(name);
        }
        
        // Filter way
        System.out.println();
        Stream<String> animalStream = Arrays.stream(animals);
        animalStream
            .filter(x -> !x.matches(".*s$"))
            .sorted()
            .forEach(System.out::println);
    }
}
