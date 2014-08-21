package com.yy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Person{
	void walk();
	void sayHello(String name);
}

class MyPerson implements Person{
	public MyPerson() {
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("myperson walk");
	}

	@Override
	public void sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("myperson:"+name+"walk");
		
	}
}

class MyInvocationHandler implements InvocationHandler{
	public Object invoke(Object proxy,Method method,Object[] args){
		System.out.println("正在执行的方法："+method);
		if(args!=null){
			System.out.println("paramters as below:");
			for(Object val:args){
				System.out.println(val);
			}
		}
		else{
			System.out.println("invalid call");
		}
		
		return null;
		
	}
}

public class MyProxy {
	
	InvocationHandler handler=new MyInvocationHandler();
	
	public static void main(String[] args) {
		InvocationHandler handler=new MyInvocationHandler();
		Person p=(Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class}, handler);
		p.walk();
		System.out.println("**************************");
		p.sayHello("yyyy");
		
		System.out.println("another try~~~~~~~~~~~~~~");
		Person myperson=new MyPerson();
		myperson.sayHello("why me!");
		System.out.println("&&&&&&&&&&&&&&&&&&");
		myperson.walk();
		
	}

}
