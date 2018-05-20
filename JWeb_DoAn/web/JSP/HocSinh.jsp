<%-- 
    Document   : HocSinh
    Created on : May 17, 2018, 1:24:41 PM
    Author     : Tuyen
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="DAO.UserCurDAO"%>
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
        <title>Student Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <div class="row justify-content-md-center">
        <div class="col-md-auto">
        <h1>Xin chào:  <a href="index.jsp">${param.username} (Student)</a></h1>
        <br>
        <h4>
        <form action="cauhoi" method="get">
            <input type="hidden" name="username" value="${param.username}">
            <%
                        String user=request.getParameter("username");
                        CauHoiDAO dao=new CauHoiDAO();
                        TraLoiDAO tlDAO=new TraLoiDAO();
                        UserCurDAO uDAO=new UserCurDAO();
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
                        if(uDAO.isHasUser(user)==false){
                            uDAO.setCurrentIndex(count, user);
                        } else{
                            uDAO.updateCurrentIndex(user, count);
                        }
                    %>
            <table>
                <tr>
                    Câu hỏi số <%pageContext.setAttribute("STT", count);%> ${STT}:
                </tr>
                <br>
                <tr>
                    <% pageContext.setAttribute("NoiDung",ch.getNoiDung()); %> 
                    <textarea readonly="true" class="form-control" rows="5" id="comment">${NoiDung}</textarea> 
                </tr>
                <br>
                <tr>
                    Câu trả lời:
                </tr>        
                <tr>
                <br>
                <textarea class="form-control" rows="5" id="comment" type="text" name="ans">${ans}</textarea> 
                <!--<input type="text" name="ans" value="${ans}" rows="5"-->
                </tr>
                <br>
                <tr>
                    <div class="btn-group btn-group-justified">
                    <div class="btn-group">
                    <button class="btn btn-primary " type="submit" name='id' value="${STT-1}">Back</button>
                    </div>
                    <div class="btn-group">
                    <button class="btn btn-primary " type="submit" name='id' value="${STT+1}">Next</button>
                    </div>
                    </div>
                </tr>

            </table>
        </form>
        </h4>
        </div>
        </div>
        </div>
    </body>
</html>
