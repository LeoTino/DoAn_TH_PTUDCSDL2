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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <div class="row justify-content-md-center">
        <div class="col-md-auto">
        <div class="Absolute-Center is-Responsive">
            <br> <br> <br> <br>
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
                        <input class="btn btn-primary" type="submit" value="Đăng nhập"
                    </td>
                </tr>
            </table>
        </form>
        </div>
        </div>
        </div>
        </div>
    </body>
</html>
