package me.ye.javaeedemo.dao.impl;

import me.ye.javaeedemo.annotation.Entity;
import me.ye.javaeedemo.dao.GenericDAO;
import me.ye.javaeedemo.util.JDBCUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 * Implementation of GenericDAO
 *
 * @author Jacob
 * @date 2018/1/4
 */
public class GenericDAOImpl<T, ID> implements GenericDAO<T, ID> {

    private static final Logger LOGGER = Logger.getLogger("DAO");

    @Override
    public T findById(ID id, Class<T> clazz) {
        Connection connection = null;
        T entity = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT * FROM ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            String tableName = getTableName(clazz);
            statement.setString(1, tableName);
            statement.setObject(2, id);
            LOGGER.info("Execute query: " + sql);
            resultSet = statement.executeQuery();
            Field[] fields = clazz.getFields();
            while (resultSet.next()) {
                course.setId(resultSet.getLong(1));
                course.setName(resultSet.getString(2));
                course.setLecturer(resultSet.getString(3));
                course.setCategory(resultSet.getString(4));
            }
            LOGGER.info("Get course where id is " + id + " successfully");
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }

        return course;
        return null;
    }

    private String getTableName(Class<T> clazz) {
        String tableName = null;
        if (clazz.isAnnotationPresent(Entity.class)) {
            Entity entity = clazz.getAnnotation(Entity.class);
            tableName = entity.value();
        }

        return tableName;
    }

    private T setEntity(Class<T> clazz, ResultSet resultSet) {
        T t = null;
        try {
            t = clazz.newInstance();
            Field[] fields = clazz.getFields();
            for (int i = 0; i < fields.length; i++) {
                resultSet.getObject(i);
                Field field = fields[1];
                field.set();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return  t;
    }
}
