package com.file;

import java.io.File;
import java.io.IOException;

public class FileClassDEmo {
	
	public void getFileDetails(File file) {
		
	System.out.println(file.exists());;
	System.out.println(file.isDirectory());;
	//System.out.println(file.lastModified());;
	System.out.println(file.getName());;
	System.out.println(file.getAbsolutePath());;
	System.out.println(file.getPath());;
	System.out.println(file.canExecute());;
	System.out.println(file.canRead());;
	
	}
	
	public static void main(String[] args) throws Exception {
		
		FileClassDEmo fcd = new FileClassDEmo();
		
		File file = new File("MyFile");
		file.createNewFile();
		
		fcd.getFileDetails(file);
		
	}
}
