package ch3.ex2;

import java.util.Random;

public class Demo12_FluentRandom {
    
    public static void main(String[] args) {
        FluentRandom fr = new FluentRandom();
        
        printHead5(fr);
        
        printHead5(fr.asLower(5)
            .asUpper(25)
            .useAsSeed(35));
        
    }

    private static void printHead5(FluentRandom fr) {
        for(int i = 0; i < 5; i++) {
            System.out.println(fr. nextInt());
        }
        System.out.println("== done ==");
    }
}

class FluentRandom extends Random {
    
    private static final long serialVersionUID = 1L;
    private int lower = 0;
    private int upper = Integer.MAX_VALUE;
    
    public FluentRandom useAsSeed(long seed) {
        this.setSeed(seed);
        return this;
    }
    
    public FluentRandom asLower(int lower) {
        this.lower = lower;
        return this;
    }
    
    public FluentRandom asUpper(int upper) {
        this.upper = upper;
        return this;
    }

    @Override
    public int nextInt() {
        return lower + this.nextInt(upper - lower);
    }
    
}