package fp.ch2.ex2;

import java.lang.instrument.IllegalClassFormatException;

public class Demo20_LambdaException {
	
	public static void main(String[] args) throws IllegalClassFormatException {
		
		Demo20_DemoInterface di = (m, n) -> {
			if(m == 0) {
				throw new IllegalClassFormatException();
			}
			return m + ":" + n;				
		};

		System.out.println(di.concatenate(0, 45));
		
	}
}

