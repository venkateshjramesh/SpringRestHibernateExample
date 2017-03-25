package org.arpit.java2blog.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository(value = "commonRepository")
@Transactional
public class CommonRepository {

    @Autowired
    SessionFactory sessionFactory;


    public <T> Serializable save(T entity) {
        Session session = getSession();
        return session.save(entity);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Class<T> clazz, Serializable id) {
        Session session = getSession();
        return (T) session.get(clazz, id);
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public <T> void update(T entity) {
        getSession().update(entity);
    }

    public <T> void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> clazz, Object... nameValues) {
        Criteria criteria = findMatchingObjects(clazz, nameValues);
        return (T) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public <T> T load(Class<T> clazz, Serializable id) {
        return (T) getSession().load(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> clazz, Object... nameValues) {
        return findMatchingObjects(clazz, nameValues).list();
    }

    public <T> List<T> findAllInAsc(Class<T> clazz, String orderByProperty) {
        return findAllWithOrderBy(clazz, orderByProperty, true);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAllWithOrderBy(Class<T> clazz, String orderByProperty, boolean isAscending, Object... nameValues) {
        Criteria criteria = findMatchingObjects(clazz, nameValues);
        if (isAscending)
            criteria.addOrder(Order.asc(orderByProperty));
        else
            criteria.addOrder(Order.desc(orderByProperty));

        return criteria.list();
    }

    public <T> Criteria findMatchingObjects(Class<T> clazz, Object[] nameValues) {
        if (nameValues.length % 2 == 1)
            throw new IllegalArgumentException("Parameters should contain name value sequentially.");

        Criteria criteria = getSession().createCriteria(clazz);
        for (int i = 0; i < nameValues.length; i = i + 2) {
            criteria.add(Restrictions.eq((String) nameValues[i], nameValues[i + 1]));
        }
        return criteria;
    }
     public Query createQuery(String queryString) {
        return getSession().createQuery(queryString);
    }
}
