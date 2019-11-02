package com.cbtuser.dao;

import java.util.List;

/**
 *
 * @author Redwolfer
 */
public interface DaoService <T> {
    
    int addData(T object);
    
    int updateData(T object);
    
    int deleteData(T object);
    
    List<T> getAllData();
    
    T getOneData(T object);
    
}
