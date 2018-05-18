<%-- 
    Document   : HocSinh
    Created on : May 17, 2018, 1:24:41 PM
    Author     : Tuyen
--%>

<%@page import="DAO.TraLoiDAO"%>
<%@page import="DAO.TaiKhoanDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.CauHoi"%>
<%@page import="DAO.CauHoiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user=request.getParameter("username");
            session = request.getSession(false);
            if(user==null & session==null){
                RequestDispatcher dist=request.getRequestDispatcher("/");
                dist.forward(request, response);
            }
        %>
        <h1>Xin chào:  ${param.username}</h1>
        <br>
        <form action="cauhoi" method="get">
            <input type="hidden" name="username" value="${param.username}">
            <%
                        CauHoiDAO dao=new CauHoiDAO();
                        TraLoiDAO tlDAO=new TraLoiDAO();
                        //int stt=Integer.parseInt((request.getParameter("STT")));
                        int count=0;
                        if(request.getParameter("id")!=null){
                            count=Integer.parseInt(request.getParameter("id"));
                        }
                        //int id=Integer.parseInt(stt);
                        CauHoi ch=new CauHoi();
                        //ch.setSTT(Integer.parseInt(stt));
                        ch.setNoiDung(dao.getNoiDung(count));
                        String tl= tlDAO.getTraLoi(count, user);
                        pageContext.setAttribute("ans",tl);
                    %>
            <table>
                <tr>
                    Câu hỏi số <%pageContext.setAttribute("STT", count);%> ${STT}:
                </tr>
                <br>
                <tr>
                    <% pageContext.setAttribute("NoiDung",ch.getNoiDung()); %> ${NoiDung}
                </tr>
                <br>
                <tr>
                    Câu trả lời:
                </tr>        
                <tr>
                <br>
                <input type="text" name="ans" value="${ans}">
                </tr>
                <br>
                <tr>
                    <td><button type="submit" name='id' value="${STT-1}">Back</button></td>
                    <td><button type="submit" name='id' value="${STT+1}">Next</button></td>
                    <td><button type="submit" name="id" value="${-1}"> Logout </button></td>
                </tr>

            </table>
        </form>
    </body>
</html>
