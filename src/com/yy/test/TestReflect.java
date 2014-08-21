package com.yy.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestReflect {
	public String name;
	private TestReflect(){
		
	}
	public TestReflect(String name){
		System.out.println("执行有参数构造器");
	}
	
	public void info(){
		System.out.println("执行无参数info方法");
	}
	public void info(String str){
		System.out.println("执行you参数info方法"+str);
		
	}
	
	public void info(String str,Integer num){
		System.out.println("执行有参数的info方法"+str+" and "+num);
	}
	class inner{}
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
//		Class<TestReflect> clazz=TestReflect.class;
//		Constructor[] ctors=clazz.getDeclaredConstructors();
//		System.out.println("testreflect constructor as below:");
//		for(Constructor c :ctors){
//			System.out.println(c);
//		}
		
		Class<TestReflect> clazz=TestReflect.class;
		Class clazz2=Class.forName("com.yy.test.TestReflect");
//		Class clazz3=Class.forName("TestReflect$inner");
		Constructor[] ctors=clazz.getDeclaredConstructors();
		System.out.println("constructor as below:");
		for(Constructor c:ctors){
			System.out.println(c);
		}
		
		
		Method[] mets=clazz2.getMethods();
		for(Method m:mets){
			System.out.println(m);
		}
		
		Field[] f=clazz2.getFields();
		for(Field myf:f){
			System.out.println(myf);
		}
		
		Method ct=clazz2.getMethod("info", String.class);
		ct.invoke(clazz2.newInstance(), "yy");
		Annotation[] at=clazz.getAnnotations();		
		
		Object arr=Array.newInstance(String.class,10 );
		Array.set(arr, 5, "yy1");
		Object book1=Array.get(arr, 5);
		
		
	}
	

}
