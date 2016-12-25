package com.global.common.framework;

import java.io.Serializable;

public interface HibernateDao 
{
	public Object get(Class entityClass, Serializable id);
	
	public void persist(Object entityClass);
}
