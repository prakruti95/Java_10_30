package com.bo;

import java.util.List;

import com.dao.MyDao;
import com.model.Person;

public class Mybo 
{
	MyDao dao;

	public MyDao getDao() 
	{
		return dao;
	}

	public void setDao(MyDao dao) 
	{
		this.dao = dao;
	}
	
	public void insertdata(Person p)
	{
		dao.insertdata(p);
	}
	public void updatedata(Person p)
	{
		dao.updatedata(p);
	}
	public void deletedata(int id)
	{
		dao.deletedata(id);
	}
	public List<Person> viewdata()
	{
		return dao.viewdata();
		
	}
	
	
}
