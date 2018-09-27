<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>League of Courses</title>

    <link rel="stylesheet" href="./public/css/normalize.css">
    <link rel="stylesheet" href="./app/styles/login/login.css">
</head>
<body>
  <div class="bg">
    <div class="login-table-wrapper">
      <div class="login-table">
        <div class="left-part">
          <img class="utd-logo" src="./public/assets/imgs/utdlogo.png" alt="The University of Texas at Dallas -- CS 6359">
        </div>
        <div class="right-part">
          <form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >

            <h4 class="title">User Name</h4>
            <div class="input-wrapper">
                <input type="text" name="username" id="username"><br>
            </div>

            <h4 class="title">Password</h4>
            <div class="input-wrapper">
                <input type="password" name="password" id="password"><br>
            </div>
            <input class="submit-btn" type="submit" name="submit" value="login"><br>
                        
            <a class="register-btn" href="register.jsp">registration</a>
           </form>
          </div>
      </div>

			<div class="db-state">
				<%out.print("Hello!"); %>
				<%= new java.util.Date() %>
				
				
				<%! int number1, number2; %>
				
				<%
					DbManager db = new DbManager();
					Connection conn = (Connection) db.getConnection();
					if(conn == null)
						out.print("failed");
					else
						out.print("succeeded");
				
				%>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="script.js"></script>
</body>
</html>