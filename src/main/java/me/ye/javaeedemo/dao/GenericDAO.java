package me.ye.javaeedemo.dao;

/**
 * GenericDAO interface
 *
 * @author Jacob
 * @date 1/2/2018
 */


public interface GenericDAO<T, ID> {

    /**
     * find entity by id
     *
     * @param id
     * @param clazz
     * @return
     */
    T findById(ID id, Class<T> clazz);

}
