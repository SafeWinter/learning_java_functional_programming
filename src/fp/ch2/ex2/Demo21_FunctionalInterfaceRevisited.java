package fp.ch2.ex2;

import java.lang.instrument.IllegalClassFormatException;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Demo21_FunctionalInterfaceRevisited {
	
	public static void main(String[] args) throws IllegalClassFormatException {
		
		// 1. Function:
		Function<String, Integer> fn = x -> Integer.parseInt(x);          fn.apply("1");
		BiFunction<Integer, Double, String> bfn = (x, y) -> x + ":" + y;  bfn.apply(1, 2.0);
		
		DoubleFunction<String> dblFn = dbl -> "[" + dbl + "]";   dblFn.apply(1.0);
		LongFunction<String> lngFn = lng -> "[" + lng + "]";     lngFn.apply(1L);
		IntFunction<String> intFn = i -> "[" + i + "]";          intFn.apply(1);
		
		DoubleToIntFunction d2iFn = d -> (int) d;      d2iFn.applyAsInt(1.0);
		DoubleToLongFunction d2lFn = d -> (long) d;    d2lFn.applyAsLong(1.0);
		
		LongToDoubleFunction l2dFn = l -> (double) l;  l2dFn.applyAsDouble(1L);
		LongToIntFunction l2iFn = l -> (int) l;        l2iFn.applyAsInt(1L);
			
		IntToDoubleFunction i2dFn = i -> (double) i;   i2dFn.applyAsDouble(1);
		IntToLongFunction i2lFn = i -> (long) i;       i2lFn.applyAsLong(1);
		
		
		// 2. Predicate:
		Predicate<String>            pd  = s -> s.length() > 1;             pd.test("a");
		BiPredicate<String, Integer> bpd = (s, i) -> (s+ i).length() > 1;   bpd.test("a", 1);
		
		DoublePredicate dblPd = d -> d > 0.0;  dblPd.test(1d);
		LongPredicate   lngPd = l -> l > 0L;   lngPd.test(1L);   
		IntPredicate    intPd = i -> i > 0;    intPd.test(1);
		
		
		// 3. Consumer:
		Consumer<String> cs = System.out::println;                                      cs.accept("a");
		BiConsumer<String, Integer> bcs = (s, i) -> System.out.printf("%s, %d", s, i);  bcs.accept("a", 1);
		
		DoubleConsumer dblCs = System.out::println;    dblCs.accept(1.0d);
		LongConsumer   lngCs = System.out::println;    lngCs.accept(1L);
		IntConsumer    intCs = System.out::println;    intCs.accept(1);
		
		ObjDoubleConsumer<String> odCs = (obj, dbl) -> System.out.println(obj + dbl);   odCs.accept("a", 1.0d);
		ObjLongConsumer<String>   olCs = (obj, lng) -> System.out.println(obj + lng);   olCs.accept("b", 1L);
		
		
		// 4. Supplier:
		Supplier<String> sp   = () -> "abc";   sp.get();
		BooleanSupplier blnSp = () -> true;    blnSp.getAsBoolean();
		DoubleSupplier  dblSp = () -> 1d;      dblSp.getAsDouble();
		LongSupplier    lngSp = () -> 1L;      lngSp.getAsLong();
		IntSupplier     intSp = () -> 1;       intSp.getAsInt();
		
		
		// 5. Operator:
		UnaryOperator<String>  uOp = t -> t + ",";           uOp.apply("str");
		BinaryOperator<String> bOp = (m, n) -> m + ":" + n;  bOp.apply("m", "n");
		
		DoubleUnaryOperator dblUop  = d -> d * 1.5;          dblUop.applyAsDouble(2.3d);
		DoubleBinaryOperator dblBop = (d1, d2) -> d1 * d2;   dblBop.applyAsDouble(1.5d, 2.5d);
		
		LongUnaryOperator lngUop = l -> l * 10l;           lngUop.applyAsLong(5l);
		LongBinaryOperator lngBop = (l1, l2) -> l1 + l2;   lngBop.applyAsLong(10l, 20l);
		
		IntUnaryOperator intUop  = i -> i + 1;             intUop.applyAsInt(5);
		IntBinaryOperator intBop = (i1, i2) -> i1 + i2;    intBop.applyAsInt(2, 3);
	}
}

