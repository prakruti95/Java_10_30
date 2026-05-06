package com.dao;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.model.Person;

public class DAO extends HibernateDaoSupport
{
	public void Insert(Person p)
	{
		this.getHibernateTemplate().save(p);
	}
}
