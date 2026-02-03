package com.a32;

import java.util.ArrayList;
import java.util.Iterator;

import com.a221.a;

public class ListEx1 
{
	public static void main(String[] args) 
	{
		ArrayList arrayList = new ArrayList();
		
		//add
		arrayList.add("Java");
		arrayList.add("Php");
		arrayList.addLast("Test2");
		arrayList.add("Python");
		arrayList.add("Spring");
		arrayList.addFirst("Test1");
		
		//arrayList.add(1);
		//arrayList.add(3, "abcd");
		
		//System.out.println(arrayList.get(0));
//	
		ArrayList arrayList2 = new ArrayList();
	
		arrayList2.add("Android");
		arrayList2.add("Ios");
		arrayList2.add("Flutter");
		arrayList2.add("Java");
		
//		arrayList.addAll(arrayList2);
//		arrayList.remove("Ios");
//		arrayList.removeAll(arrayList2);
		
		//arrayList.retainAll(arrayList2);
		
		Iterator<String> i = arrayList.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
//		Iterator<String> i2 = arrayList2.iterator();
//		
//		while(i2.hasNext())
//		{
//			System.out.println(i2.next());
//		}
	}
}
