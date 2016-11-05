package com.global.common.framework.impl;

import java.io.Serializable;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.global.common.framework.HibernateDao;

public class HibernateDaoImpl extends HibernateDaoSupport implements HibernateDao{

	public Object get(final Class entityClass, final Serializable id) {
		
		Object data = getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.setFlushMode(FlushMode.COMMIT);
				return session.get(entityClass, id);
			}
		});
		
		return data;
	}

}
