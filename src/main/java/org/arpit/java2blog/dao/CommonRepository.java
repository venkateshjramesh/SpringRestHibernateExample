package org.arpit.java2blog.dao;

import org.arpit.java2blog.model.Country;
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

    public <T> void deleteById(Class<T> clazz, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        T t = (T) session.load(clazz, new Integer(id));
        if (null != t) {
            session.delete(t);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T find(Class<T> clazz, Object... nameValues) throws NoSuchFieldException {
        Criteria criteria = findMatchingObjects(clazz, nameValues);
        return (T) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public <T> T load(Class<T> clazz, Serializable id) {
        return (T) getSession().load(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAll(Class<T> clazz, Object... nameValues) throws NoSuchFieldException {
        return findMatchingObjects(clazz, nameValues).list();
    }

    public <T> List<T> findAllInAsc(Class<T> clazz, String orderByProperty) throws NoSuchFieldException {
        return findAllWithOrderBy(clazz, orderByProperty, true);
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> findAllWithOrderBy(Class<T> clazz, String orderByProperty, boolean isAscending, Object... nameValues) throws NoSuchFieldException {
        Criteria criteria = findMatchingObjects(clazz, nameValues);
        if (isAscending)
            criteria.addOrder(Order.asc(orderByProperty));
        else
            criteria.addOrder(Order.desc(orderByProperty));

        return criteria.list();
    }

    public <T> Criteria findMatchingObjects(Class<T> clazz, Object[] nameValues) throws NoSuchFieldException {
        if (nameValues.length % 2 == 1)
            throw new IllegalArgumentException("Parameters should contain name value sequentially.");

        Criteria criteria = getSession().createCriteria(clazz);
        for (int i = 0; i < nameValues.length; i = i + 2) {
            Object parameterField = clazz.getDeclaredField((String)nameValues[i]);
            Class classParam =  clazz.getDeclaredField((String)nameValues[i]).getType();
            String paramType = classParam.toString().trim().split(" ")[1];
            if(paramType.equalsIgnoreCase("java.lang.Integer")) {
                criteria.add(Restrictions.eq((String) nameValues[i], Integer.parseInt((String)nameValues[i + 1])));
            }
            else if(paramType.equalsIgnoreCase("java.lang.Long")) {
                criteria.add(Restrictions.eq((String) nameValues[i], Long.parseLong((String)nameValues[i + 1])));
            }
            else if(paramType.equalsIgnoreCase("java.lang.Float")) {
                criteria.add(Restrictions.eq((String) nameValues[i], Float.parseFloat((String)nameValues[i + 1])));
            }
            else if(paramType.equalsIgnoreCase("java.lang.Double")) {
                criteria.add(Restrictions.eq((String) nameValues[i], Double.parseDouble((String)nameValues[i + 1])));
            }else{
                criteria.add(Restrictions.eq((String) nameValues[i], nameValues[i + 1]));
            }



            //criteria.add(Restrictions.eq((String) nameValues[i], nameValues[i + 1]));
        }
        return criteria;
    }

    public <T> List<T> getAllValues(String className) {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from " + className).list();
    }

     public Query createQuery(String queryString) {
        return getSession().createQuery(queryString);
    }
}
