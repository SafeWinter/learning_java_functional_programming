package ch3.ex1;

import ch3.ex1.Compose.ComposeFunction;

public class Demo01_OldCompose {

    public static void main(String[] args) {
        ComposeFunction<Double, Double> by2 = new ComposeFunction<>() {
            @Override
            public Double call(Double d) {
                return d * 2;
            }
        };
        ComposeFunction<Double, Double> negate = new ComposeFunction<>() {
            @Override
            public Double call(Double d) {
                return -d;
            }
        };
                
        ComposeFunction<Double, Double> compseFn = Compose.compose(by2, negate);
        System.out.println(compseFn.call(5d));
    }
}

class Compose {
    public interface ComposeFunction<T, R> {
        R call(T t);
    }
    
    public static <T, U, R> ComposeFunction<T, R> compose(
        ComposeFunction<U, R> f, ComposeFunction<T, U> g
    ){
        return new ComposeFunction<T, R>(){
            public R call(T t) {
                return f.call(g.call(t));
            }
        };
    }
}