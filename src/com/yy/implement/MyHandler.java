package com.yy.implement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.yy.util.DogUtil;

public class MyHandler implements InvocationHandler {
	public Object target;
	
	public void setTarget(Object target){
		this.target=target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		DogUtil du=new DogUtil();
		du.method1();
		System.out.println("working on target function");
		Object result=method.invoke(target, args);
		System.out.println("end on target function");
		du.method2();
		
		return result;
	}

}
