package com.algaworks.pedidovenda.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

public class HibernateGenericDAO <T, ID extends Serializable> implements GenericDAO<T, ID>{

	@Inject
	private EntityManager manager;
	
	private Class<T> classeEntidade;//classe representada pelo T
	
	
	@SuppressWarnings("unchecked")
	public HibernateGenericDAO() {
		this.classeEntidade = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T buscarPeloCodigo(ID id) {
		return manager.find(classeEntidade, id);
	}

	@Override
	public void salvar(T entidade) {
		manager.merge(entidade);
	}

	/*
	 * (non-Javadoc)
	 * @see com.algaworks.pedidovenda.dao.GenericDAO#filtrar(java.lang.Object, java.lang.String[])
	 * 
	 * para utilizar este tipo de filtro adicionar no POM a dependencia:
	 * <!-- commons beanutils -->
		<dependency>
			<groupId>commons-beanutils</groupId>
			<artifactId>commons-beanutils</artifactId>
			<version>1.9.2</version>
			<scope>compile</scope>
		</dependency>
	 */
	@Override
	public List<T> filtrar(T entidade, String... propriedades) {
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(classeEntidade);
		
		if(propriedades != null) {
			for (String propriedade : propriedades) {
				try {
					Object valor = PropertyUtils.getProperty(entidade, propriedade);
					
					if(valor != null) {
						if(valor instanceof String) {
							criteria.add(Restrictions.ilike(propriedade, (String) valor, MatchMode.ANYWHERE));
						}else {
							criteria.add(Restrictions.eq(propriedade, valor));							
						}
					}
				} catch (Exception e) {
					throw new RuntimeException("propriedade nao encontrada", e);
				}
			}
		}
		return criteria.list();
	}
	
	protected EntityManager getEntityManager() {
		return manager;
	}
	
	protected Session getSession() {
		return manager.unwrap(Session.class);
	}

}
