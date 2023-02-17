package xyz.zapgrupos.model;


import java.util.List;

public interface ServiceDAO <T> {
    public List<T> getAll();
}
