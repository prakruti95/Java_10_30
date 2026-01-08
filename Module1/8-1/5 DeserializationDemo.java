package com.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

public class DEserializationDemo {
	public static void main(String[] args) throws Exception {
		Student s=null;
		FileInputStream fis = new FileInputStream("sry");
		ObjectInputStream ois = new ObjectInputStream(fis);
		s=(Student)ois.readObject();
		System.out.println(s.sid +" "+s.sname);
	}
}
