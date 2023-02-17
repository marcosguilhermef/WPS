package xyz.zapgrupos.services;

import xyz.zapgrupos.model.Grupo;
import java.util.List;
public interface ServiceDAO<T,K> {
    public List<T> getAll();
    public T getById(K id);
    public T insert(T value);
    public T update(T value);


}
