/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DBconnect.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Tuyen
 */
public class TraLoiDAO {
    public void setRecordTraLoi(int id,String ans,String username) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="insert into TraLoi(Username,STTCauHoi,CauTraLoi) values(N'"+username+"',"+id+",N'"+ans+"')";
        Statement st=conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void updatetRecordTraLoi(int id,String ans,String username) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="update TraLoi set Username=N'"+username+"', STTCauHoi="+id+", CauTraLoi=N'"+ans+"')";
        Statement st=conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public String getTraLoi(int i, String username) throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        //int z=Integer.parseInt(i);
        String query="SELECT CauTraLoi from TraLoi where STTCauHoi="+i+" AND Username=N'"+username+"'";
        ResultSet rs=null;
        Statement st=conn.createStatement();
        rs=st.executeQuery(query);
        String ch="";
        while(rs.next()){
            ch=rs.getString("CauTraLoi");
        }
        rs.close();
        return ch;
    }
    
    public boolean isInsert(int id, String username) throws SQLException, ClassNotFoundException{
        TraLoiDAO dao=new TraLoiDAO();
        String s= getTraLoi(id,username);
        if(s==null || s==""){
            return false;
        }
        return true;
    }
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        TraLoiDAO dao=new TraLoiDAO();
        boolean s=dao.isInsert(1, "hs");
        System.out.print(s);
    }*/
}
