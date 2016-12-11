package com.jju.util;

import java.util.UUID;

public class UUIDString {
	
	public static String generatorID(){
		UUID uuid = UUID.randomUUID();
		String str = uuid.toString().replaceAll("-", "");
		//去掉-
		return str;
	}
	
	
	public static void main(String[] args) {
		String id = generatorID();
		System.out.println(id);//d1879c5f-b952-4392-b75b-5a28d917b2e1
	}
}
