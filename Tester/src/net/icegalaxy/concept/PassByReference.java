package net.icegalaxy.concept;

import java.util.ArrayList;

public class PassByReference
{

	
	public static void main(String[] args)
	{
		TestInt test1 = new TestInt(1);
		TestInt test2 = new TestInt(2);
		
		ArrayList<TestInt> tests = new ArrayList<TestInt>();
		
		tests.add(test1);
		tests.add(test2);
		
		System.out.println("test 1: " + test1.i);
		System.out.println("test 1 in array: " + tests.get(0).i);
		System.out.println("");
		
		test1.i = 3;
		
		System.out.println("test 1 after setting: " + test1.i);
		System.out.println("test 1 in array after setting: " + tests.get(0).i);
		System.out.println("");
		
		tests.get(0).i = 4;
		
		System.out.println("test 1 after array setting: " + test1.i);
		System.out.println("test 1 in array after array setting: " + tests.get(0).i);
		System.out.println("");
		
		changeTo5(test1);
		
		System.out.println("test 1 after changeTo5: " + test1.i);
		System.out.println("test 1 in array after changeTo5: " + tests.get(0).i);
		System.out.println("");
		
		
	}
	
	static void changeTo5(TestInt x)
	{
		x.i = 5;
		
	}
	
	
	
	
}


