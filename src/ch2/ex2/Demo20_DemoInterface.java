package ch2.ex2;

import java.lang.instrument.IllegalClassFormatException;

@FunctionalInterface
public interface Demo20_DemoInterface {
	public String concatenate(Integer m, Integer n) 
	    throws IllegalClassFormatException;
}

