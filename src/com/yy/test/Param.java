package com.yy.test;

import java.util.Scanner;

import org.junit.Test;

public class Param {
	
	@Test
	public void testParam(){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			System.out.println("input is "+sc.next());
		}
	}
	
	public static void main(String[] args){
		System.out.println(args.length);
		new Param().testParam();
	
	}

}
