package ch8.ex1;

import java.util.Arrays;
import java.util.List;

public class Demo02_Debug_peek {

    public static void main(String[] args) {
        /* The peek method takes an object that implements the Consumer interface. 
         * It is similar to using print type statements but is more convenient 
         * and is not necessarily limited to displaying information. 
         * It could also be used for logging type operations.*/
        
        List<String> list = Arrays.asList("Huey", "Dewey", "Louie");
        list.stream()

                .peek(s -> System.out.println("First peek-" + s))
                
                .map(s -> s + "-" + s.toLowerCase())
                
                .peek(s -> System.out.println("Second peek-" + s + ":" + s.length()))
                
                .forEach(s -> System.out.println(s));
/* Result:
First peek-Huey
Second peek-Huey-huey:9
Huey-huey
First peek-Dewey
Second peek-Dewey-dewey:11
Dewey-dewey
First peek-Louie
Second peek-Louie-louie:11
Louie-louie 
*/
    }
}
