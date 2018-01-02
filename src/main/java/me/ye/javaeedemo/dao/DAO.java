package me.ye.javaeedemo.dao;

/**
 * Created by Jacob on 1/2/2018.
 */

public interface DAO<T, ID> {

    T findById(ID id);

}
