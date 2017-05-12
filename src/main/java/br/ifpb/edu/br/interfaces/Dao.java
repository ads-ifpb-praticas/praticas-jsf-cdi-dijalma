package br.ifpb.edu.br.interfaces;

import java.util.List;

/**
 * Created by <a href="http://dijalmasilva.github.io" target="_blank">dijalma</a> on 11/05/17.
 */
public interface Dao<T> {

    T save(T obj);

    T edit(T obj);

    T findOne(Long id);

    List<T> findAll();

    boolean remove(T obj);
}
