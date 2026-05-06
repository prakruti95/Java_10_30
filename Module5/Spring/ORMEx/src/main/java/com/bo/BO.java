package com.bo;

import org.springframework.transaction.annotation.Transactional;

import com.dao.DAO;
import com.model.Person;

@Transactional
public class BO 
{
	DAO dao;

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
	public void Insert(Person p)
	{
		dao.Insert(p);
	}
	
}
