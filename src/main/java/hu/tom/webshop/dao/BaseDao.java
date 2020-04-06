package hu.tom.webshop.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class BaseDao<T> {

    private final Class<T> entityClass;
    private Session currentSession;
    private Transaction currentTransaction;

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
        currentSession = HibernateUtil.getSessionFactory().openSession();
    }

    private void openTransaction() {
        currentTransaction = currentSession.getTransaction();
    }

    public void save(T entity) {
        openTransaction();
        currentTransaction.begin();
        currentSession.save(entity);
        currentTransaction.commit();
    }

    public T merge(T entity) {
        openTransaction();
        currentTransaction.begin();
        T result = (T) currentSession.merge(entity);
        currentTransaction.commit();
        return entity;
    }

    public void delete(T entity) {
        openTransaction();
        currentTransaction.begin();
        currentSession.delete(entity);
        currentTransaction.commit();
    }

    public T findById(Long Id) {
        return currentSession.get(entityClass, Id);
    }
}
