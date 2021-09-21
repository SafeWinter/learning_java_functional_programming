package ch3.ex1;

import java.util.HashMap;
import java.util.Map;

public class Demo08_MethodChaining_Cascading {

    public static void main(String[] args) {
        // Prior to Java 8
        String animal = "Cat";
        String concat = animal.concat("Dog");
        String lower = concat.toLowerCase();
        int length = lower.length();
        System.out.println(lower);
        System.out.println(length);
        
        // Method chaining
        System.out.println(animal
            .concat("Dog")
            .toLowerCase());
        System.out.println(animal
            .concat("Dog")
            .toLowerCase()
            .length());
        
        Map<String,String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        map.put("c", "C");
        String word = "cat";
        String result = map.computeIfAbsent(word, x->x).concat("s").toUpperCase();
        System.out.println(result);
    }
    
}
