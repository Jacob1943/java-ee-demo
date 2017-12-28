package me.ye.javaeedemo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 * Created by Jacob on 12/28/2017.
 */

public class JDBCUtils {

    private static final Logger LOGGER = Logger.getLogger("JDBCUtils");

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useSSL=false",
                    "root", "Root-1943");
            LOGGER.info("Get JDBC connection successfully");

        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        }
        return conn;
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        try {
            if (resultSet != null) {
                resultSet.close();
                LOGGER.info("Close result set successfully");
            }
            if (statement != null) {
                statement.close();
                LOGGER.info("Close statement set successfully");
            }
            if (connection != null) {
                connection.close();
                LOGGER.info("Close connection set successfully");
            }
        } catch (Exception ex) {
            LOGGER.severe("An error encountered: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
