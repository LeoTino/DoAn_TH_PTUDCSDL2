/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBconnect;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Tuyen
 */
public class SQL {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //2. Tạo kết nối đến CSDL
        String conString ="jdbc:sqlserver://127.0.0.1:52770;" + "databasename=DoAn";
        String username="leo";
        String password="Hiep123456789";
        Connection connection;
        connection = DriverManager.getConnection(conString,username,password);
        return connection;
    }
    
}
