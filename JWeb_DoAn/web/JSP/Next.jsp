<%-- 
    Document   : Next
    Created on : May 17, 2018, 11:40:24 PM
    Author     : Tuyen
--%>

<%@page import="DAO.TaiKhoanDAO"%>
<%@page import="DAO.TraLoiDAO"%>
<%@page import="Model.CauHoi"%>
<%@page import="DAO.CauHoiDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <div class="row justify-content-md-center">
        <div class="col-lg-auto">
        <%
            String lecturerName=request.getParameter("gv");
            String studentName=request.getParameter("hs");
            TaiKhoanDAO tkDAO=new TaiKhoanDAO();
            String pw=tkDAO.getPassword(lecturerName);
            pageContext.setAttribute("pass",pw);
        %>
        <form action="user" method="post">
                    <input type="hidden" name="username" value="${param.gv}" />
                    <input type="hidden" name="password" value="${pass}" />
                    <button class="btn btn-link" type="submit"><h2>[${param.gv}] [${param.hs}]</h2></button>
         </form>
                    
        <%
            //String s="<h2> ["+lecturerName+"] ["+studentName+"]</h2><br>";
            //out.println(s);
            int stt=Integer.parseInt(request.getParameter("cauhoi"));
            CauHoiDAO chDAO=new CauHoiDAO();
            String nd=chDAO.getNoiDung(stt);
            pageContext.setAttribute("noidung",nd);
            
            TraLoiDAO tlDAO=new TraLoiDAO();
            
            String tl= tlDAO.getTraLoi(stt, studentName);
            pageContext.setAttribute("traloi",tl);
            
            String tlcx=chDAO.getCauTraLoiChinhXac(stt);
            pageContext.setAttribute("traloiCX", tlcx);
        %>
        

        <h5>
        <table>
            <tr>
            <label>Câu hỏi số ${param.cauhoi}:  </label> 
            </tr>
            <br>
            <tr>
            <textarea readonly="true" class="form-control" rows="5" id="comment">${noidung}</textarea>
            </tr>
            <br>
            <tr>
            <label>Câu trả lời của sinh viên: </label>
            </tr>
            <br>
            <tr>
                <textarea readonly="true" class="form-control" rows="5" id="comment">${traloi}</textarea>
            </tr>
            <br>
            <tr>
            <label>Câu trả lời chính xác:</label>    
            </tr>
            <br>
            <tr>
            <textarea readonly="true" class="form-control" rows="5" id="comment">${traloiCX}</textarea>   
            </tr>
            <br>
            <tr>
                <form action="bailam">
                    <input type="hidden" name="gv" value="${param.gv}" />
                    <input type="hidden" name="hs" value="${param.hs}" />
                    <button class="btn btn-primary" type="submit" name="cauhoi" value="${param.cauhoi-1}">Back</button>
                    <button class="btn btn-primary" type="submit" name="cauhoi" value="${param.cauhoi+1}">Next</button>
                </form>
            </tr>
        </table>
        </h5>
        </div>
        </div>
        </div>
    </body>
</html>
