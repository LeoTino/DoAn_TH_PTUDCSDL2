<%-- 
    Document   : index
    Created on : May 17, 2018, 10:58:54 AM
    Author     : Tuyen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="user" method="post">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td><label>Password: </label></td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Đăng nhập"
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
