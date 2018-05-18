<%-- 
    Document   : Next
    Created on : May 17, 2018, 11:40:24 PM
    Author     : Tuyen
--%>

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
        <h1>Hello World!</h1>
        <form action="HocSinh.jsp" method="GET">
            <input type="text" name="ans">
            <input type="number" name="id">
            
                    <br>
                    
            <button type="submit">Click</button>
        </form>
    </body>
</html>
