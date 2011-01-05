package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

public class Test {

	public Object getProperty(Object owner, String fieldName) throws Exception {
		
		//得到该对象的Class
		Class ownerClass = owner.getClass();
		//通过Class得到类声明属性
		Field field = ownerClass.getField(fieldName);
		//通过对象得到该属性的实例，如果这个属性是非公有的，会报IllegalAccessException
		Object property = field.get(owner);
		
		return property;
	}
	
	public static void main(String[] args){
	
		
		
		
	}
}
