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
public class TaiKhoan {
    private String username;
    private String password;
    private String loaiTK;
    
    public TaiKhoan(){
        
    }
    
    public TaiKhoan(String username,String password, String loaiTK){
        this.loaiTK=loaiTK;
        this.password=password;
        this.username=username;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return this.username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    
    public void setloaiTK(String loaiTK){
        this.loaiTK=loaiTK;
    }
    public String getLoaiTK(){
        return this.loaiTK;
    }
}
