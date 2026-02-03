package com.a32;

import java.util.ArrayList;
import java.util.Iterator;

import com.a221.a;

public class ListEx3 
{
	public static void main(String[] args) 
	{
		ArrayList arrayList = new ArrayList();
		
		
		arrayList.add("Java");
		arrayList.add("Php");
		arrayList.add("Python");
		arrayList.add("Spring");
		arrayList.add("Java");
		
	
		Iterator<String> i = arrayList.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

	}
}
