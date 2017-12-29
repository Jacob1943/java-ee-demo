package me.ye.javaeedemo.util;


import org.junit.Test;

import java.sql.Connection;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Jacob on 12/29/2017.
 */

public class JDBCUtilsTest {

    @Test
    public void testGetConnection() {
        Connection connection = JDBCUtils.getConnection();
        assertNotNull(connection);
    }

}
