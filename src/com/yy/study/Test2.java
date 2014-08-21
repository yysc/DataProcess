package com.yy.study;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader cl=ClassLoader.getSystemClassLoader();
		//cl.loadClass("Tester");
		System.out.println("***************");
		Class.forName("Tester");
	}
}
