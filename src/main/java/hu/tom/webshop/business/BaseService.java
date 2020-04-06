package hu.tom.webshop.business;

import hu.tom.webshop.domain.CpuArchitectType;

import java.util.List;

public interface BaseService<T> {

    public void create(T t);

    public T findById(Long Id);

    public T update(T t);

    public void delete(T t);
}
