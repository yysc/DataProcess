package com.yy.test;

import java.lang.reflect.Proxy;

import com.yy.implement.DogMy;
import com.yy.implement.MyHandler;
import com.yy.interfaces.Dog;

public class TestmyProxy {
	public static Object getProxy(Object target){
		MyHandler handler=new MyHandler();
		handler.setTarget(target);
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), handler);
	}
	public static void main(String[] args) {
		Dog target=new DogMy();
		Dog dog=(Dog)TestmyProxy.getProxy(target);
		dog.info();
		dog.run();

	}

}
