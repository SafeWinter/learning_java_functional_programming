package ch5.ex1;

import java.util.stream.Stream;

public class Demo02_HeadTailRecursion {

    public static void main(String[] args) {
        String phrase = "Recursion";
        head(phrase);
        System.out.println();
        tail(phrase);
        System.out.println();
        
        head1(phrase);
        Stream.generate(() -> "-")
            .limit(phrase.length())
            .forEach(System.out::print);
        System.out.println();
        tail1(phrase);
    }
    
    public static void head(String phrase) {
        if(phrase.length() == 0) {
            return;
        }
        head(phrase.substring(1));
        System.out.print(phrase.charAt(0));
    }
    
    public static void tail(String phrase) {
        if(phrase.length() == 0) {
            return;
        }
        System.out.print(phrase.charAt(0));
        tail(phrase.substring(1));
    }
    
    
    public static void head1(String phrase) {
        if(phrase.length() == 0) {
            return;
        }
        head1(phrase.substring(1));
        System.out.println(phrase);
    }
    
    public static void tail1(String phrase) {
        if(phrase.length() == 0) {
            return;
        }
        System.out.println(phrase);
        tail1(phrase.substring(1));
    }
}
