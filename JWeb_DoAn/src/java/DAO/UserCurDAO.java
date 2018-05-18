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
public class UserCurDAO {
    public void setCurrentIndex(int i, String username) throws SQLException, ClassNotFoundException{
        Connection conn= SQL.getConnection();
        String query="insert into UserCur(Username,CurrentIndex) values(N'"+username+"',"+i+")";
        Statement st=conn.createStatement();
        st.executeUpdate(query);
        conn.close();
        //return query;
    }
    
    public int getCurrentIndex(String username) throws SQLException, ClassNotFoundException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="SELECT CurrentIndex from UserCur where Username=N'"+username+"'";
        ResultSet rs=null;
        Statement st=conn.createStatement();
        rs=st.executeQuery(query);
        int ch=-1;
        while(rs.next()){
            ch=Integer.parseInt(rs.getString("CurrentIndex"));
        }
        rs.close();
        return ch;
    }
    
    public void updateCurrentIndex(String username, int currentIndex) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="update UserCur set CurrentIndex="+currentIndex+" where Username=N'"+username+"'";
        Statement st=conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public boolean isHasUser(String username) throws SQLException, ClassNotFoundException{
        UserCurDAO dao= new UserCurDAO();
        int curIndex=dao.getCurrentIndex(username);
        if(curIndex==-1){
            return false;
        }
        return true;
    }
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        UserCurDAO dao= new UserCurDAO();
        boolean x=dao.isHasUser("hs");
        //String x=dao.setCurrentIndex(8, "ddsa");
        //int x=dao.getCurrentIndex("ddsa");
        System.out.print(x);

    }*/
}
