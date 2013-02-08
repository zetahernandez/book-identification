package com.book.identification.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

import com.book.identification.HibernateUtil;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	Object object = new Object();
	private Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Obtiene la sesion activa
	 * 
	 * @return
	 */
	public Session getSession() {
		if (session == null || !session.isOpen()) {
			session = HibernateUtil.getSessionFactory().openSession();
		}
		return session;
	}

	/**
	 * Devuelve la clase que se persiste
	 * 
	 * @return
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	/**
	 * Busca por Id
	 * 
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) this.getSession().load(getPersistentClass(), id,
					LockOptions.UPGRADE);
		else {
			entity = (T) this.getSession().load(getPersistentClass(), id);
		}
		return entity;
	}
	

	/**
	 * Trae todos los elementos
	 * 
	 * @return
	 */
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, String... excludeProperty) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		Example example = Example.create(exampleInstance);
		for (String exclude : excludeProperty) {
			example.excludeProperty(exclude);
		}
		crit.add(example);
		return crit.list();
	}

	/**
	 * Guarda o Actualiza
	 * 
	 * @param entity
	 * @return
	 */
	public T makePersistent(T entity) {
		synchronized (object) {
			getSession().saveOrUpdate(entity);
		}
		return entity;
	}

	public void makeTransient(T entity) {
		getSession().delete(entity);
		
	}
	/**
	 * Delete
	 * 
	 * @param entity
	 */
	public void delete(T entity) {
		getSession().delete(entity);
	}

	public void flush() {
		getSession().flush();
	}

	public void clear() {
		getSession().clear();
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}
        /**
	 * Obtenemos la cantidad de registros usando la query como parametro
	 * @param qCount
	 * @return int 
	 */
	protected int getCantOfRows( String qCount ,int initialPage, int cantRows) {
            int qCountResult = 0;
            Long result = (Long)getSession().createQuery(qCount).
                                                setFirstResult(initialPage).
                                                setMaxResults( cantRows ).
                                                uniqueResult();
            if ( result != null ){
                qCountResult = result.intValue();
            }
              
            return qCountResult;
	}
}