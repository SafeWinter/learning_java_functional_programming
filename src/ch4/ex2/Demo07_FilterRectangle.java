package ch4.ex2;

import java.util.Arrays;
import java.util.function.Function;

public class Demo07_FilterRectangle {

    public static void main(String[] args) {
        Rectangle[] rectangles = {
            new Rectangle(10, 10, 50, 75),
            new Rectangle(30, 40, 30, 45),
            new Rectangle(110, 70, 70, 15),
            new Rectangle(50, 10, 45, 35)
        };
        
        Function<Rectangle, Integer> rectToX = r -> r.getX();
        Function<Integer, Boolean> greaterThanTen = n -> n > 10;
        
        Arrays.stream(rectangles)
            .filter(rectToX.andThen(greaterThanTen)::apply)
            .forEach(System.out::println);
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