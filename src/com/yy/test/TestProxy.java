package com.yy.test;

import java.lang.reflect.Array;

public class TestProxy {

	public static void main(String[] args){
		Object arr=Array.newInstance(String.class, 3,4,10);
		Object arrObj=Array.get(arr, 2);
		Array.set(arrObj, 2, new String[]{
				"Struts2权威指南",
				"轻量级应用"});
		Object anarr=Array.get(arrObj, 3);
		Array.set(anarr, 8, "test set");
		String[][][] castFromArr=(String [][][])arr;
		System.out.println(castFromArr[2][3][8]);
		System.out.println(castFromArr[2][2][0]);
		System.out.println(castFromArr[2][2][1]);
		
		
	}
}
