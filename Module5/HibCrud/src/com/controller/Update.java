package com.controller;

import java.util.Scanner;

import com.dao.Dao;
import com.model.Person;

public class Update 
{
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ID");
		int id = sc.nextInt();
		
		System.out.println("Enter Name");
		String name = sc.next();
		
		System.out.println("Enter Password");
		String pass = sc.next();
		
		Person p = new Person();
		p.setId(id);
		p.setName(name);
		p.setPassword(pass);
		
		new Dao().updatedata(p);
	}
}
