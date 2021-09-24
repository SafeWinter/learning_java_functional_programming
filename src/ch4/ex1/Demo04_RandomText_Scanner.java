package ch4.ex1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Demo04_RandomText_Scanner {
	
	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in);) {
			
			Stream.iterate(scanner.next(), s -> scanner.next())
					.forEach(System.out::println);
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
	}
}
