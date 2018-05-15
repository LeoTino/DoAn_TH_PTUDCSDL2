/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.CauHoi;
import DBconnect.SQL;
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
public class CauHoiDAO {
    public List<CauHoi> getAll() throws SQLException, ClassNotFoundException{
        Connection conn=SQL.getConnection();
        String query="SELECT STTCauHoi,NoiDungCauHoi,CauTraLoiChinhXac from CauHoi";
        ResultSet rs=null;
        List<CauHoi>lst=new ArrayList<>();
        try{
            if(conn!=null){
                Statement st=conn.createStatement();
                rs=st.executeQuery(query);
                CauHoi ch=null;
                while(rs.next()){
                    ch=new CauHoi();
                    ch.setNoiDung(rs.getString("NoiDungCauHoi"));
                    ch.setSTT(rs.getInt("STTCauHoi"));
                    ch.setTraLoiDung(rs.getString("CauTraLoiChinhXac"));
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
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        CauHoiDAO dao=new CauHoiDAO();
        for(CauHoi ch:dao.getAll()){
            System.out.println(ch.getSTT()+" - "+ch.getNoiDung()+" - "+ch.getTraLoiDung()+"\n");
        }
    }
}
