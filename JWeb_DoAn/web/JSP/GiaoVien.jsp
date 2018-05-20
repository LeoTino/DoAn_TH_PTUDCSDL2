<%-- 
    Document   : GiaoVien
    Created on : May 17, 2018, 1:24:52 PM
    Author     : Tuyen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.TaiKhoanDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lecturer Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <div class="row justify-content-md-center">
        <div class="col-md-auto">
        <h1>Xin chào:  <a href="index.jsp">${param.username} (Lecturer)</a></h1>
        <br>
        <h1>Danh sách sinh viên:</h1>
        <!--<form action="JSP/Next.jsp" method="get">-->
        <h3>
        <%
            TaiKhoanDAO tkDAO=new TaiKhoanDAO();
            List<String> lst=new ArrayList<>();
            lst= tkDAO.getTenHocSinh();
            int sl=tkDAO.getSoHocSinh();
            String gv=request.getParameter("username");
            pageContext.setAttribute("sl", sl);
            for(int i=1;i<=sl;i++){
                String ten=lst.get(i-1);
                String s="<h2><a href=\"bailam?gv="+gv+"&hs="+ten+"&cauhoi=1\">"+ ten +"</a></h2><br>";
                out.println(s);     
            }
            

            
        %>
        </h3>
        </div>
        </div>
        </div>
    </body>
</html>
