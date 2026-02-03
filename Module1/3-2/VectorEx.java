package com.a32;

import java.util.Vector;

public class VectorEx 
{
	public static void main(String[] args)
	{
		Vector v = new Vector(5);
		
		v.addElement("a");
		v.addElement("b");
		v.addElement("c");
		v.addElement("d");
		v.addElement("a");
		v.addElement("d");
		v.addElement("a");
		v.addElement("d");
		v.addElement("a");
		v.addElement("d");
		v.addElement("a");
		
		System.out.println(v);
		
		System.out.println("Size: "+v.size());
		System.out.println("Capacity: "+v.capacity());
		System.out.println(v.contains("a"));
		v.clear();
	}
}
