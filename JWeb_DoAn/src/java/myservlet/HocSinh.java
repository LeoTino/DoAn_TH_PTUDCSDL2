/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import DAO.CauHoiDAO;
import DAO.TraLoiDAO;
import DAO.UserCurDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
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
@WebServlet(urlPatterns = {"/cauhoi"})
public class HocSinh extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GiaoVien</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GiaoVien at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request,response);
        int count=0;
        int temp=0;
        int stt = 0;
        HttpSession session;  
        session = request.getSession(false);
        count=Integer.parseInt(request.getParameter("id"));
        String ans=request.getParameter("ans");
        String username=request.getParameter("username");
        TraLoiDAO tlDAO=new TraLoiDAO();
        CauHoiDAO dao=new CauHoiDAO();
        UserCurDAO uDAO=new UserCurDAO();
        
        try {
            if(tlDAO.isInsert(uDAO.getCurrentIndex(username), username)==false){
                tlDAO.setRecordTraLoi(uDAO.getCurrentIndex(username), ans, username);
            }
            else{
                tlDAO.updatetRecordTraLoi(uDAO.getCurrentIndex(username), ans, username);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(HocSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(session!=null){  
            if(request.getParameter("id")!=null){
                try {
                    if(dao.getSoCau()<count){
                        count=1;
                    }
                    else if(count==0){
                        count=dao.getSoCau();
                    }
                    else if(count==-1){
                        temp=1;
                        //int a=dao.getSoCau();
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(HocSinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(temp==0){
                RequestDispatcher dist=request.getRequestDispatcher("/JSP/HocSinh.jsp?id="+count);
                dist.forward(request, response);  
            }
            else{  
                session.invalidate(); 
                response.sendRedirect("index.jsp");
            }
        }  
        else if(session==null) {
            //request.setAttribute("username", "Please login to continue");
            RequestDispatcher dist=request.getRequestDispatcher("index.jsp");
            dist.forward(request, response);
        }
    }
}
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
*/

