/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tuyen
 */
public class CauHoi {
    private int STT;
    private String NoiDung;
    private String TraLoiDung;
    
    public CauHoi(){
        
    }
    
    public CauHoi(int STT,String NoiDung,String TraLoiDung){
        this.STT=STT;
        this.NoiDung=NoiDung;
        this.TraLoiDung=TraLoiDung;
    }
    
    public void setSTT(int STT){
        this.STT=STT;
    }
    public int getSTT(){
        return this.STT;
    }
    
    public void setNoiDung(String NoiDung){
        this.NoiDung=NoiDung;
    }
    public String getNoiDung(){
        return this.NoiDung;
    }
    
    public void setTraLoiDung(String tlDung){
        this.TraLoiDung=tlDung;
    }
    public String getTraLoiDung(){
        return this.TraLoiDung;
    }
}












