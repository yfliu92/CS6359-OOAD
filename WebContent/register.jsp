<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="script.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register</title>
	<link rel="stylesheet" href="<%= basePath %>public/css/normalize.css">
	<link rel="stylesheet" href="<%= basePath %>app/styles/register/register.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<div class="bg">
		<div class="register-table-wrapper">
			<div class="register-table">

				<form name="regform" action="LoginController" method="post" onsubmit="return regValidate()">
					<%--<br>${message}<br>--%>
					<%--Username: <input type="text" name="id"> <br>--%>
					<%--<div id="username_error"></div><br>--%>
					<h3 class="title">Sign Up Your Account</h3>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputUserName">User Name</label>
							<input type="text" name="id" class="form-control" id="inputUserName" placeholder="User name">
						</div>
						<div class="form-group col-md-6">
							<label for="inputEmail">Email</label>
							<input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputFistName">First Name</label>
							<input type="text" name="f_name" class="form-control" id="inputFistName" placeholder="First name">
						</div>
						<div class="form-group col-md-6">
							<label for="inputLastName">Last Name</label>
							<input type="text" name="l_name" class="form-control" id="inputLastName" placeholder="Last name">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="inputPassword">Password</label>
							<input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-12">
							<label for="retry-password">Re-Type Password</label>
							<input type="password" name="retry-password" class="form-control" id="retry-password" placeholder="Re-Type Password">
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputSchool">School</label>
							<input type="text" name="school" class="form-control" id="inputSchool" placeholder="School">
						</div>
						<div class="form-group col-md-6">
							<label for="inputYear">Year</label>
							<input type="text" name="year" class="form-control" id="inputYear" placeholder="Year">
						</div>
					</div>
					<%--Email: <input type="email" name="email"><br>--%>
					<%--School: <input type="text" name="school"><br>--%>
					<%--Year: <input type="text" name="year"><br>--%>
					<%--Password: <input type="password" name="password" id="password">--%>
					<%--<br>--%>
					<%--Re-Type Password: <input type="password" name="retry-password" id="retry-password">--%>
					<%--<br>--%>

					<div class="form-row">
						<div class="col-md-6">
							<button type="submit" name="submit" value="register" class="btn btn-primary btn-block">Submit</button>
						</div>
						<div class="col-md-6">
							<button type="reset" name="reset"class="btn btn-secondary btn-block">Reset</button>
						</div>
					</div>
					<%--<div id="password_error"></div><br>--%>
				</form>
			</div>
		</div>

	</div>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
			integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
			crossorigin="anonymous"></script>
</body>
</html>