package com.bo;

import java.util.List;

import com.dao.DAO;
import com.model.Person;

public class BO {
private DAO dao;

public DAO getDao() {
	return dao;
}

public void setDao(DAO dao) {
	this.dao = dao;
}

public void Add(Person p)
{
this.dao.Insert(p);
}
public void Remove(Person p)
{
	this.dao.Delete(p);
}
public void Edit(Person p)
{
	this.dao.Update(p);
}
public Person getOne(Person p)
{
	Person p1 = this.dao.getSingle(p);
	return p1;
}
public List<Person> ViewRecords()
{
	List<Person> getlist = this.dao.getall();
	return getlist;
}


}
