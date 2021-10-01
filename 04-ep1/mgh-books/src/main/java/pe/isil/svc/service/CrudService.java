package pe.isil.svc.service;

import java.util.List;

public interface CrudService<T, ID> {
    T create(T t);
    T update(T t);
    void delete(ID id);
    T findById(ID id);
    List<T> findAll();
}
