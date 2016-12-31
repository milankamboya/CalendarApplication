package com.global.common.framework;

import java.io.Serializable;
import java.util.List;

public interface HibernateDao 
{
	public Object get(Class entityClass, Serializable id);
	
	public void persist(Object entityClass);
	
	public List selectByNamedQuery(String namedQueryString, String param);
	
	public List selectByNamedQuery1(String namedQueryString, String param);
}
