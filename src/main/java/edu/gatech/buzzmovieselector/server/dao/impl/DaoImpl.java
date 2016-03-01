package edu.gatech.buzzmovieselector.server.dao.impl;

import edu.gatech.buzzmovieselector.server.dao.Dao;
import edu.gatech.buzzmovieselector.server.dao.HibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * Base class for the Database Access Objects that handle the reading and
 * writing a class from the database.
 *
 * @param <T>  The class that the code will be operating on.
 * @param <ID> The class of the ID column associated with the class. The T
 *             class does not require an ID field. The class
 *             needs an ID parameter however so you can use Void or Object to
 *             satisfy the compiler.
 */
@SuppressWarnings(value = "unchecked")
public abstract class DaoImpl<T, ID extends Serializable> implements Dao<T,
        ID> {

    protected final Class<T> dataClass;

    protected DaoImpl(Class<T> dataClass) {
        this.dataClass = dataClass;
    }

    public T findById(ID id) throws SQLException {
        Session session = null;
        Transaction tx = null;
        T result = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            result = (T) session.get(dataClass, id);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return result;
    }

    public List<T> findAll() throws SQLException {
        Session session = null;
        Transaction tx = null;
        List<T> result = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            result = (List<T>) session.createQuery("from " + dataClass
                    .getName())
                    .list();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
        return result;
    }

    public void create(T data) throws SQLException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.save(data);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public void update(T data) throws SQLException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.update(data);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public void createOrUpdate(T data) throws SQLException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.saveOrUpdate(data);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    public void delete(T data) throws SQLException {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateSessionFactory.getSession();
            tx = session.beginTransaction();
            session.delete(data);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
}