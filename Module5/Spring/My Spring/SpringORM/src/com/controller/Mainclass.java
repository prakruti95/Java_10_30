package com.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bo.BO;
import com.model.Person;

public class Mainclass {
public static void main(String[] args) {
	ApplicationContext con = new ClassPathXmlApplicationContext("tops.xml");
	Scanner sc = new Scanner(System.in);
	BO bo = (BO) con.getBean("bo");
	Person p  =  (Person) con.getBean("model");
	/*
	 * Insert OP
	 * System.out.println("Enter name:");
	
	p.setName(sc.next());
	bo.Add(p);*/
	
	
	/*
	 * Update OP
	 * 
	System.out.println("Enter id:");
	p.setId(sc.nextInt());
	 System.out.println("Enter name:");
	 p.setName(sc.next());
	 bo.Edit(p);*/
	
	/*
	 * DELETE OP
	 * System.out.println("Enter id:");
	p.setId(sc.nextInt());
	bo.Remove(p);
	*/
	
	/*
	 * SINGLE OP
	 * System.out.println("Enter id:");
	p.setId(sc.nextInt());
	p = bo.getOne(p);
	System.out.println(p.getName());
	*/
	
	List<Person> getall = bo.ViewRecords();
	System.out.println("ID\t|\tName");
	for (Person person : getall) {
		System.out.println(person.getId()+"\t|\t"+person.getName());
	}
}
}
