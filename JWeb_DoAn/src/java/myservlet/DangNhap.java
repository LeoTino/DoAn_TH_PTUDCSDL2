/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import DAO.TaiKhoanDAO;
import DBconnect.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Tuyen
 */
@WebServlet(urlPatterns = {"/user"})
public class DangNhap extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DangNhap</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DangNhap at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }*/

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }*/

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    //int i=-1;
    String name;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            name = request.getParameter("username");
            String pass = request.getParameter("password");
            response.setContentType("text/html; charset=UTF-8");
            TaiKhoanDAO tk=new TaiKhoanDAO();
            if(tk.CheckLoginGiaoVien(name, pass)){
                //i=0;
                HttpSession session;
                session=request.getSession();  
                session.setAttribute("username",name); 
                RequestDispatcher dist=request.getRequestDispatcher("JSP/GiaoVien.jsp?username="+name);
                dist.forward(request, response);
            }
            else if(tk.CheckLoginHocSinh(name, pass)){
                //i=1;
                HttpSession session;
                session=request.getSession();  
                session.setAttribute("username",name); 
                RequestDispatcher dist=request.getRequestDispatcher("JSP/HocSinh.jsp?username="+name+"&id=1");
                dist.forward(request, response);
            }
            else{
                //session.setAttribute("username", "Ban nhap sai Username/Password");
                RequestDispatcher dist=request.getRequestDispatcher("index.jsp");
                dist.forward(request, response);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=null;
        session.removeAttribute("username");
        response.sendRedirect("index.jsp");
    }
    /*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(i==0){
            RequestDispatcher dist=request.getRequestDispatcher("JSP/GiaoVien.jsp?username="+name);
            dist.forward(request, response);
        }
        else if(i==1){
            RequestDispatcher dist=request.getRequestDispatcher("JSP/HocSinh.jsp?username="+name+"&stt=1");
            dist.forward(request, response);
        }
        else if(i==-1){
            RequestDispatcher dist=request.getRequestDispatcher("index.jsp");
            dist.forward(request, response);
        }
    }*/

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
