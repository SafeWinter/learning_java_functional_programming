package ch4.ex2;

public class Demo10_IterativeMapping {

    public static void main(String[] args) {
        Rectangle1[] rectangles = {
            new Rectangle1(10, 10, 50, 75),
            new Rectangle1(30, 40, 30, 45),
            new Rectangle1(110, 70, 70, 15),
            new Rectangle1(50, 10, 45, 35)
        };
        
        // Iterative approach
        System.out.println("Iterative mapping");
        for (Rectangle1 rectangle : rectangles) {
            rectangle.scale(0.25);
        }
        int total = 0;
        for (Rectangle1 rectangle : rectangles) {
            total += rectangle.getArea();
        }
        System.out.println(total);
    }
}

class Rectangle1 {
    private int x;
    private int y;
    private int height;
    private int width;
    
    public Rectangle1(int x, int y, int height, int width) {
        super();
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public Rectangle1 scale(double percent) {
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