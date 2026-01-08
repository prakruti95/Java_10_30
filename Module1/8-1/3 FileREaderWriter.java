package com.file;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileREaderWriter {
	public static void main(String[] args) throws Exception {
		
		FileWriter fw = new FileWriter("tops1.txt");
		String s = "Hello , this is my data";
		fw.write(s);
		fw.flush();
		fw.close();
		
		FileReader fr = new FileReader("tops1.txt");
		int i=0;
	
		while((i=fr.read())!=-1) {
			System.out.print((char)i);
		}
	}
}
