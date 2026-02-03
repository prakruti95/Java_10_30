package com.a32;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

import com.a221.a;

public class SetEx2 
{
	public static void main(String[] args) 
	{
		HashSet set1 = new HashSet();
		
		
		set1.add("105");
		set1.add("101");
		set1.add("102");
		set1.add("104");
		set1.add("103");
		
	
		Iterator<String> i = set1.iterator();
		
		while(i.hasNext())
		{
			System.out.println(i.next());
		}

	}
}
