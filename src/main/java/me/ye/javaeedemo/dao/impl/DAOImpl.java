package me.ye.javaeedemo.dao.impl;

import me.ye.javaeedemo.dao.DAO;
import me.ye.javaeedemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 * Created by Jacob on 1/2/2018.
 */


public class DAOImpl<T, ID> implements DAO<T, ID> {

    private static final Logger LOGGER = Logger.getLogger("DAO");

    @Override
    public T findById(ID id) {
//        Connection connection = null;
//        T entity = null;
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        try {
//            connection = JDBCUtils.getConnection();
//            String sql = "SELECT * FROM ? WHERE id = ?";
//            statement = connection.prepareStatement(sql);
//            Class<T> clazz = Class.forName()
//            statement.setString(1, entityName);
//            statement.setObject(2, id);
//            LOGGER.info("Execute query: " + sql);
//            resultSet = statement.executeQuery();
//            T t = new T();
//            while (resultSet.next()) {
//                course.setId(resultSet.getLong(1));
//                course.setName(resultSet.getString(2));
//                course.setLecturer(resultSet.getString(3));
//                course.setCategory(resultSet.getString(4));
//            }
//            LOGGER.info("Get course where id is " + id + " successfully");
//        } catch (Exception ex) {
//            LOGGER.severe("An error encountered: " + ex.getMessage());
//            ex.printStackTrace();
//        } finally {
//            JDBCUtils.close(resultSet, statement, connection);
//        }
//
//        return course;
        return null;
    }
}
