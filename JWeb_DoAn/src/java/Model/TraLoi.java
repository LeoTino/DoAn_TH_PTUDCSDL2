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
public class TraLoi {
    private String Username;
    private int STTCauHoi;
    private String CauTL;
    
    public TraLoi(){
        
    }
    
    public TraLoi(String Username,int STTCauHoi,String CauTL){
        this.CauTL=CauTL;
        this.STTCauHoi=STTCauHoi;
        this.Username=Username;
    }
    
    public void setUsername(String username){
        this.Username=username;
    }
    public String getUsername(){
        return this.Username;
    }
    
    public void setSTTCauHoi(int stt){
        this.STTCauHoi=stt;
    }
    public int getSTTCauHoi(){
        return this.STTCauHoi;
    }
    
    public void setCauTL(String tl){
        this.CauTL=tl;
    }
    public String getCauTL(){
        return this.CauTL;
    }
}
