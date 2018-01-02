package me.ye.javaeedemo.dao.impl;

import me.ye.javaeedemo.dao.AccountDAO;
import me.ye.javaeedemo.entity.Account;
import me.ye.javaeedemo.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Created by Jacob on 1/2/2018.
 */

public class AccountDAOImpl implements AccountDAO {

    private static final Logger LOGGER = Logger.getLogger("AccountDAO");

    @Override
    public Account findById(String id) {
        Connection connection = null;
        Account account =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String SQL = "SELECT * FROM account WHERE id = ?";
            statement = connection.prepareStatement(SQL);
            statement.setString(1, id);
            LOGGER.info("Execute query: " + SQL);
            resultSet = statement.executeQuery();
            account = new Account();
            while (resultSet.next()) {
                account.setId(resultSet.getString(1));
                account.setRole(resultSet.getString(2));
                account.setRoleId(resultSet.getLong(3));
                account.setPassword(resultSet.getString(4));
                account.setSalt(resultSet.getString(5));
            }
            LOGGER.info("Get course where id is " + id + " successfully");
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            JDBCUtils.close(resultSet, statement, connection);
        }
        return account;
    }
}
