/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBconnect.SQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Tuyen
 */
public class TaiKhoanDAO {
    public boolean CheckLoginGiaoVien(String username,String password) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="SELECT Username, Password, LoaiTK from TaiKhoan";
        ResultSet rs=null;
        Statement st=conn.createStatement();
            rs=st.executeQuery(query);
            boolean bool=false;
            while(rs.next()){
                if(username.equals(rs.getString("Username")) && password.equals(rs.getString("Password")) 
                        && rs.getInt("LoaiTK")==1){
                    bool=true;
                }   
            }
            rs.close();
            return bool;
    }
    
    public boolean CheckLoginHocSinh(String username,String password) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="SELECT Username, Password, LoaiTK from TaiKhoan";
        ResultSet rs=null;
        Statement st=conn.createStatement();
            rs=st.executeQuery(query);
            boolean bool=false;
            while(rs.next()){
                if(username.equals(rs.getString("Username")) && password.equals(rs.getString("Password")) 
                        && rs.getInt("LoaiTK")==0){
                    bool=true;
                }   
            }
            rs.close();
            return bool;
    }
    
    //piblic boolean isLogged() 
    
    
    
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        boolean bool;
        TaiKhoanDAO tk=new TaiKhoanDAO();
        bool= tk.CheckLoginHocSinh("hs","hs");
        if(bool==true)
            System.out.println("Dung");
        else
            System.out.println("Sai");
    }*/
}

