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
    
    public int updatetRecordTraLoi(int id,String ans,String username) throws SQLException, ClassNotFoundException{
        int i;
        try (Connection conn = SQL.getConnection()) {
            String query="update TraLoi set CauTraLoi=N'"+ans+"' where Username=N'"+username+"' and STTCauHoi="+id;
            Statement st=conn.createStatement();
            i = st.executeUpdate(query);
        }
        return i;
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
        String s;
        s = getTraLoi(id,username);
        if(s==null || s==""){
            return false;
        }
        return true;
    }
    
    /*public static void main(String[] args) throws SQLException, ClassNotFoundException{
        TraLoiDAO dao=new TraLoiDAO();
        //dao.setRecordTraLoi(5, "dsadsadsadas", "hs");
        
        //if(i==false)
        //    dao.setRecordTraLoi(0, ans, username);
        //String i=dao.getTraLoi(5, "dsadas");
        boolean j=dao.isInsert(5, "hs");
        System.out.print(j);

    }*/
}
