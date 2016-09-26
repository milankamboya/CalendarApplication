package com.global.common.framework;

import java.io.Serializable;

public interface HibernateDao {

	Object get(Class entityClass, Serializable id);
}
