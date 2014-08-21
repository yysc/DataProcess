package com.yy.implement;

import com.yy.interfaces.Dog;

public class DogMy implements Dog{
	@Override
	public void info() {
		// TODO Auto-generated method stub
		System.out.println("im my dog");
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("my dog running");
	}

}
