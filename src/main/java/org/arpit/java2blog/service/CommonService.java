package org.arpit.java2blog.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.arpit.java2blog.dao.CommonRepository;
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
	public <T> Serializable saveValue(String className,String json) throws ClassNotFoundException, IOException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return commonRepository.save(mapper.readValue(json, clazz));
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
	public <T> T find(String className, Object... nameValues) throws ClassNotFoundException, NoSuchFieldException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		return (T) commonRepository.find(clazz, nameValues);
	}

	@Transactional
	public <T> List<T> findAll(String className, Object... nameValues) throws ClassNotFoundException, NoSuchFieldException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		return commonRepository.findAll(clazz, nameValues);
	}

	@Transactional
	public <T> List<T> getAllValues(String className) {
		return commonRepository.getAllValues(className);
	}

	@Transactional
	public <T> List<T> findAllInAsc(String className, String orderByProperty) throws ClassNotFoundException, NoSuchFieldException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return commonRepository.findAllInAsc(clazz, orderByProperty);
	}

	@Transactional
	public <T> List<T> findAllWithOrderBy(String className, String orderByProperty, boolean isAscending, Object... nameValues) throws ClassNotFoundException, NoSuchFieldException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return commonRepository.findAllWithOrderBy(clazz,orderByProperty,isAscending,nameValues);
	}


	@Transactional
	public <T> void delete(String className,String json) throws ClassNotFoundException, IOException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		commonRepository.delete(mapper.readValue(json, clazz));
	}

	@Transactional
	public <T> void deleteById(String className,int id) throws ClassNotFoundException, IOException {
		Class<T> clazz = (Class<T>) Class.forName("org.arpit.java2blog.model." + className);
		commonRepository.deleteById(clazz,id);
	}

	@Transactional
	public <T> T load(Class<T> clazz, Serializable id) {
		return (T) commonRepository.getSession().load(clazz, id);
	}


	/*@Transactional
	public Query createQuery(String queryString) {
		return getSession().createQuery(queryString);
	}*/
}
