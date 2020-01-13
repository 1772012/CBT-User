package com.cbtuser.dao;

import java.util.List;

/**
 * @author Kafka Febianto Agiharta - 1772012
 * @param <T>
 */
public interface DaoService<T> {

    int addData(T object);

    List<T> getAllData();

    T getOneData(T object);
}
