package ch3.ex1;

public class Demo09_ChainingVsCascading {

    public static void main(String[] args) {
        Number number = new Number();
        
        Number chained = number.chainedMethod(1);
        System.out.println(chained);

        Number cascaded = number.cascadedMethod(1);
        System.out.println(cascaded);
    }
}

class Number {
    
    public Number chainedMethod(int num) {
        Number newTest = new Number();
        // use num
        return newTest;
    }
    
    public Number cascadedMethod(int num) {
        // use num
        return this;
        
        // for cascading:
        // 1. return the original object
        // 2. 'this' object must be mutable
    }
}
