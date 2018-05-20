/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DBconnect.SQL;
import Model.CauHoi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    public int getSoHocSinh() throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        //int z=Integer.parseInt(i);
        String query="select count(Username) as soLuong  from  TaiKhoan where LoaiTK=0";
        ResultSet rs=null;
        Statement st=conn.createStatement();
        rs=st.executeQuery(query);
        int ch=0;
        while(rs.next()){
            ch=rs.getInt("soLuong");
        }
        rs.close();
        return ch;
    }
    
    public List<String> getTenHocSinh() throws SQLException, ClassNotFoundException{
        List<String> lst=new ArrayList<>();
        Connection conn=SQL.getConnection();
        String query="SELECT Username from TaiKhoan where LoaiTK=0";
        ResultSet rs=null;
        try{
            if(conn!=null){
                Statement st=conn.createStatement();
                rs=st.executeQuery(query);
                String ch=null;
                while(rs.next()){
                    ch=rs.getString("Username");
                    lst.add(ch);
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            if(conn!=null){
                try{
                    rs.close();
                    conn.close();
                } catch(SQLException ex){
                    Logger.getLogger(DBconnect.SQL.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        
        return lst;
    }
    
    public String getPassword(String username) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        //int z=Integer.parseInt(i);
        String query="select Password from  TaiKhoan where Username=N'"+username+"'";
        ResultSet rs=null;
        Statement st=conn.createStatement();
        rs=st.executeQuery(query);
        String ch = null;
        while(rs.next()){
            ch=rs.getString("Password");
        }
        rs.close();
        return ch;
    }
    
    
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        TaiKhoanDAO tk=new TaiKhoanDAO();
        String pass=tk.getPassword("gv");
        System.out.print(pass);
    }*/
}

