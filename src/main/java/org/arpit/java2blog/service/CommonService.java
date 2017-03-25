package org.arpit.java2blog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arpit.java2blog.dao.CommonRepository;
import org.arpit.java2blog.dao.CountryDAO;
import org.arpit.java2blog.model.Country;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Service("commonService")
public class CommonService {

	@Autowired
	CommonRepository commonRepository;

	@Transactional
	public <T> Serializable save(T entity) {
		return commonRepository.save(entity);
	}

	@Transactional
	public <T> T get(String className, Serializable id) throws ClassNotFoundException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		return (T) commonRepository.get(clazz, id);
	}


	@Transactional
	public <T> void updateValue(String className,String json) throws ClassNotFoundException, IOException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		commonRepository.update(mapper.readValue(json, clazz));
	}

	@Transactional
	public <T> T find(String className, Object... nameValues) throws ClassNotFoundException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		return (T) commonRepository.find(clazz, nameValues);
	}

	@Transactional
	public <T> List<T> findAll(String className, Object... nameValues) throws ClassNotFoundException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		return commonRepository.findAll(clazz, nameValues);
	}



	/*@Transactional
	public <T> void delete(T entity) {
		getSession().delete(entity);
	}



	@Transactional
	public <T> T load(Class<T> clazz, Serializable id) {
		return (T) getSession().load(clazz, id);
	}



	@Transactional
	public <T> List<T> findAllInAsc(Class<T> clazz, String orderByProperty) {
		return findAllWithOrderBy(clazz, orderByProperty, true);
	}

	@Transactional
	public <T> List<T> findAllWithOrderBy(Class<T> clazz, String orderByProperty, boolean isAscending, Object... nameValues) {
		Criteria criteria = findMatchingObjects(clazz, nameValues);
		if (isAscending)
			criteria.addOrder(Order.asc(orderByProperty));
		else
			criteria.addOrder(Order.desc(orderByProperty));

		return criteria.list();
	}



	@Transactional
	public Query createQuery(String queryString) {
		return getSession().createQuery(queryString);
	}*/
}
