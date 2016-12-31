package com.global.common.framework.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.global.common.framework.HibernateDao;

public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao
{

	public Object get(final Class entityClass, final Serializable id) 
	{
		if (logger.isDebugEnabled()) logger.debug("get entity: " + entityClass+" id="+id);
		Object data = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.setHibernateFlushMode(FlushMode.COMMIT);
				return session.get(entityClass, id);
			}
		});
		
		return data;
	}
	
	public void persist(final Object entityClass) 
	{
		if (logger.isDebugEnabled()) logger.debug("saving entity: " + entityClass);
		
		HibernateTemplate ht = getHibernateTemplate();
		ht.persist(entityClass);
		ht.flush();
	}

	public List<Map<String,Object>> selectByNamedQuery(final String namedQueryString, final String param) 
	{
		/*if (logger.isDebugEnabled()) logger.debug("selecting data for query : " + queryString+" and parameteres ="+ values.toString());
		List data = getHibernateTemplate().find(queryString, values);
		return data;*/
		
		if (logger.isDebugEnabled()) logger.debug("selecting data for query : " + namedQueryString+" and parameteres ="+ param.toString());
		List data = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.setHibernateFlushMode(FlushMode.COMMIT);
				Query query = session.getNamedQuery(namedQueryString);  
			    query.setString("email", param);  
			    return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				//return query.list();
			}
		});
		
		return data;
	}
	
	public List selectByNamedQuery1(final String namedQueryString, final String param) 
	{
		/*if (logger.isDebugEnabled()) logger.debug("selecting data for query : " + queryString+" and parameteres ="+ values.toString());
		List data = getHibernateTemplate().find(queryString, values);
		return data;*/
		
		if (logger.isDebugEnabled()) logger.debug("selecting data for query : " + namedQueryString+" and parameteres ="+ param.toString());
		List data = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.setHibernateFlushMode(FlushMode.COMMIT);
				Query query = session.getNamedQuery(namedQueryString);  
			    query.setString("email", param);  
			    //return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
				return query.list();
			}
		});
		
		return data;
	}
	
}
