package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Stack;

public class Test {

	public Object getProperty(Object owner, String fieldName) throws Exception {
		
		//�õ��ö����Class
		Class ownerClass = owner.getClass();
		//ͨ��Class�õ�����������
		Field field = ownerClass.getField(fieldName);
		//ͨ������õ������Ե�ʵ���������������Ƿǹ��еģ��ᱨIllegalAccessException
		Object property = field.get(owner);
		
		return property;
	}
	
	public static void main(String[] args){
		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getDeclaredMethods();
			for(int i=0;i<m.length;i++)
				System.out.println(m[i].toString());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
