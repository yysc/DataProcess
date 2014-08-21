package com.yy.study;

class littleTest{
	static{
		System.out.println("init my class.....");
	}
	static String myVar="test just";
	static final String myVar2="another test";
	
}
public class InitTest {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
//		System.out.println(littleTest.myVar);
//		System.out.println("******************");
//		System.out.println(littleTest.myVar2);
		
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		cl.loadClass("littleTest");
		Class.forName("littleTest");

	}

}
