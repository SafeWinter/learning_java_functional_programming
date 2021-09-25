package ch4.ex2;

import java.util.Arrays;

public class Demo11_StreamMapping {
    
    private static Rectangle2[] getRectangles() {
        return new Rectangle2[] {
            new Rectangle2(10, 10, 50, 75),
            new Rectangle2(30, 40, 30, 45),
            new Rectangle2(110, 70, 70, 15),
            new Rectangle2(50, 10, 45, 35)
        };
    }

    public static void main(String[] args) {
        
        // Stream approach using map
        System.out.println("Stream mapping");
        
        // Approach 1
        Rectangle2[] rectangles1 = getRectangles();
        int total = Arrays.stream(rectangles1)
                .map(r -> r.scale(0.25))
                .mapToInt(Rectangle2::getArea)
                .sum();
        System.out.println(total);
        
        // Approach 2
        Rectangle2[] rectangles2 = getRectangles();
        total = Arrays.stream(rectangles2)
                .map(r -> r.scale(0.25))
                .mapToInt(Rectangle2::getArea)
                .reduce(0, (r, s) -> r + s);
        System.out.println(total);
        
        System.out.println("Check out the detail:");
        
        // Check out the detail - iterative approach
        Rectangle2[] rectangles3 = getRectangles();
        total = 0;
        for (Rectangle2 rectangle : rectangles3) {
            rectangle.scale(0.25);
            int area = rectangle.getArea();
            System.out.println(total + " - " + area);
            total += area;
        }
        System.out.println(total);
        
        // Check out the detail - stream approach
        total = Arrays.stream(getRectangles())
            .map(r -> r.scale(0.25))
            .mapToInt(Rectangle2::getArea)
            .reduce(0, (r, s) -> {
                System.out.println(r + " - " + s);
                return r + s;
            });
        System.out.println(total);
    }
}

class Rectangle2 {
    private int x;
    private int y;
    private int height;
    private int width;
    
    public Rectangle2(int x, int y, int height, int width) {
        super();
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public Rectangle2 scale(double percent) {
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