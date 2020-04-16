package hu.tom.webshop.business;

public interface BaseService<T> {

    public void create(T t);

    public T findById(Long Id);

    public T update(T t);

    public void delete(T t);
}
