package com.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Student implements Serializable{
	int sid;
	String sname;
	public Student(int sid,String sname) {
		this.sid=sid;
		this.sname=sname;
	}
}
public class SerializationDemo {
	public static void main(String[] args) throws Exception {
		Student s = new Student(1, "Parth");
		FileOutputStream fos = new FileOutputStream("sry");
		ObjectOutputStream oos =new ObjectOutputStream(fos);
		oos.writeObject(s);
	}
}
