package ch6.ex3;

import java.util.Optional;
import java.util.function.Function;


class Demo17_Jdk8_optional_monad_laws {
    public static void main (String[] args) throws java.lang.Exception
    {
    	boolean rs1 = satisfiesLaw1LeftIdentity();
    	boolean rs2 = satisfiesLaw2RightIdentity();
    	boolean rs3 = satisfiesLaw3Associativity();
    	
        System.out.println("");
        System.out.println("Does JDK8's Optional class satisfy the Monad laws?");
        System.out.println("=================================================");
        System.out.println("  1.  Left identity:  " + rs1);
        System.out.println("  2.  Right identity: " + rs2);
        System.out.println("  3.  Associativity:  " + rs3);
        System.out.println("");
        System.out.println(rs1 && rs2 && rs3 ? "Yes, it does." : "No, it doesn't.");
    }

    // Input values for the monad law tests below
    static int value = 42;
    static Optional<Integer> monadicValue = Optional.of(value);

    // (pass `Optional.of` directly)
    static Function<Integer, Optional<Integer>> optionalOf = n -> Optional.of(n);

    static Function<Integer, Optional<Integer>> f = n -> Optional.of(n * 2);  

    static Function<Integer, Optional<Integer>> g = n -> Optional.of(n * 5);

    static Function<Integer, Optional<Integer>> f_flatMap_g = n -> f.apply(n).flatMap(g);  


    /**
     * Monad law 1, Left Identity
     *
     * From LYAHFGG [1] above: 
     *   The first monad law states that if we take a value, put it in a default context 
     *   with return and then feed it to a function by using >>=, it¡¯s the same as just 
     *   taking the value and applying the function to it
     */
    public static boolean satisfiesLaw1LeftIdentity() {
        return Optional.of(value).flatMap(f)
            .equals(f.apply(value));
    }

    /**
     * Monad law 2, Right Identity
     *
     * From LYAHFGG [1] above: 
     *   The second law states that if we have a monadic value and we use >>= to feed 
     *   it to return, the result is our original monadic value.
     */
    public static boolean satisfiesLaw2RightIdentity() {
        return monadicValue.flatMap(Optional::of)
            .equals(monadicValue);
    }

    /**
     * Monad law 3, Associativity
     *
     * From LYAHFGG [1] above: 
     *   The final monad law says that when we have a chain of monadic function 
     *   applications with >>=, it shouldn¡¯t matter how they¡¯re nested.
     */
    public static boolean satisfiesLaw3Associativity() {
        return monadicValue.flatMap(f).flatMap(g)
            .equals(monadicValue.flatMap(f_flatMap_g));
    }
}