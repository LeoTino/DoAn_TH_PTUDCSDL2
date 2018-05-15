/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuyen
 */
import java.util.Properties;
import java.sql.*;

public class SQLConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        //1. Đăng ký driver và tạo kết nối đến CSDL
        Driver driver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
        DriverManager.registerDriver(driver);
        //2. Tạo kết nối đến CSDL
        String conString ="jdbc:sqlserver://127.0.0.1:1433;" + "databasename=DoAn;user=sa;password=";
        Properties info = new Properties();
        info.setProperty("characterEncoding", "utf8");
        info.setProperty("user", "root");
        info.setProperty("password", "");
        Connection connection;
        connection = DriverManager.getConnection(conString,info);
        //3. Tạo đối tượng Statement để thực hiện thao tác dữ liệu mong muốn
        Statement statement = connection.createStatement();
        String sql = "insert into TaiKhoan(Username,Password,LoaiTK) values(nguyenvana,123456,hs)";

        boolean kq = statement.execute(sql);
        
        connection.close();
    }
}
