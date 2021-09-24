package ch4.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo02_FiniteStream {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		int[] numbers = {3,6,8,8,4,6,3,3,5,6,9,4,3,6};
	    IntStream intStream = Arrays.stream(numbers);
	    
	    Rectangle[] rectangles = {
    		new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
	    };
	    Stream<Rectangle> rectangleStream = Arrays.stream(rectangles);
	    
	    List<String> cities = new ArrayList<>();
	    cities.add("London");
	    cities.add("Paris");
	    cities.add("Cairo");
	    cities.add("Manila");
	    Stream<String> cityStream = cities.stream();
	}
}

class Rectangle {
	private int x;
	private int y;
	private int height;
	private int width;
	
	public Rectangle(int x, int y, int height, int width) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle scale(double percent) {
		this.height = (int) (height * (1.0d + percent));
		this.width = (int) (width * (1.0d + percent));
		return this;
	}
	
	public int getArea() {
		return this.height * this.width;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public String toString() {
        return "X: " + x + " Y: " + y 
                + " Height: " + height + " Width: " + width;
    }
}