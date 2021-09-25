package ch4.ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo12_flatMap {

    public static void main(String[] args) {
        // concat demo
        List<Rectangle3> list1 = Arrays.asList(
            new Rectangle3(10, 10, 20, 20),
            new Rectangle3(10, 20, 30, 40),
            new Rectangle3(40, 30, 20, 20));
        List<Rectangle3> list2 = Arrays.asList(
            new Rectangle3(50, 50, 30, 30),
            new Rectangle3(60, 60, 20, 20));
        
        Stream<Rectangle3> stream1 = list1.stream();
        Stream<Rectangle3> stream2 = list2.stream();
        
        Stream<Rectangle3> concatenatedStream = Stream.concat(stream1, stream2);
        concatenatedStream.forEach(System.out::println);
        
        // flatMap demo
        System.out.println("===== flatMap demo =====");
        List<List<Rectangle3>> list3 = Arrays.asList(
                Arrays.asList(new Rectangle3(10, 10, 20, 20),
                        new Rectangle3(10, 20, 30, 40),
                        new Rectangle3(40, 30, 20, 20)),
                Arrays.asList(new Rectangle3(50, 50, 30, 30),
                        new Rectangle3(60, 60, 20, 20)),
                Arrays.asList(new Rectangle3(100, 100, 30, 40),
                        new Rectangle3(110, 10, 20, 20),
                        new Rectangle3(120, 10, 50, 60))
        );
        
        // conventional way
        List<Rectangle3> result1 = new ArrayList<>();
        for (List<Rectangle3> list : list3) {
            result1.addAll(list);
        }
        for (Rectangle3 rectangle : result1) {
            System.out.println(rectangle);
        }
        
        System.out.println();
        
        // stream way
        list3.stream()
            .flatMap(list -> list.stream())
            .forEach(System.out::println);
        
        // use flatMap to modify stream elements
        list3.stream()
            .flatMap(list -> list.stream()
                .map(r -> r.height(30))
                .filter(r -> r.getArea() > 900))
            .mapToInt(Rectangle3::getArea)
            .distinct()
            .forEach(System.out::println);
    }
}

class Rectangle3 {
    private int x;
    private int y;
    private int height;
    private int width;
    
    public Rectangle3(int x, int y, int height, int width) {
        super();
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    
    public Rectangle3 scale(double percent) {
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
    public Rectangle3 height(int height) {
        this.height = height;
        return this;
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