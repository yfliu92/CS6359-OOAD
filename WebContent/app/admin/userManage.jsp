<%@ page
        import="java.util.List,java.util.ArrayList,domain.User"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%= basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>League of Courses</title>

    <link rel="stylesheet" href="public/css/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="public/css/common.css">
</head>
<style type="text/css">
    table, th, tr, td {
        border: 1px solid black;
    }
</style>
<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container">
                <h1> All Users </h1>
                <%if (request.getAttribute("message") != null) { %>
                <h2>${ message }</h2>
                <%} %>
                <form action="">
                    <table>
                        <tr>
                            <th>User ID</th>
                            <th>User Name</th>
                            <th>Email</th>
                            <th>School</th>
                            <th>Year</th>
                            <th>User Type</th>
                        </tr>
                        <%
                            List<User> list = (ArrayList) request.getAttribute("ulist");
                            if (list.size() > 0) {
                                for (User u : list) {
                        %>
                        <tr>
                            <th><%=u.getId() %>
                            </th>
                            <th><%=u.getF_name() + " " + u.getL_name()%>
                            </th>
                            <th><%=u.getEmail() %>
                            </th>
                            <th><%=u.getSchool()%>
                            </th>
                            <th><%=u.getYear()%>
                            </th>
                            <th><%=u.getUser_type() == 0 ? "Admin" : u.getUser_type() == 1 ? "Student" : "Teacher"%>
                            </th>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </table>
                </form>
                <input type="button" value="Add User" onclick="showAdd()">
                <div id="adiv" style="display:none">
                    <form name="addform" method=post action="AddUserController">
                        <br>User ID: <input type="text" name="id">
                        <br>Password: <input type="text" name="pwd">
                        <br>First Name: <input type="text" name="fname">
                        <br>Last Name: <input type="text" name="lname">
                        <br>Email: <input type="text" name="email">
                        <br>School: <input type="text" name="school">
                        <br>Year: <input type="text" name="year">
                        <br>User Type:
                        <select name="userType">
                            <option value=0>Admin</option>
                            <option value=2>Teacher</option>
                            <option value=1>Student</option>
                        </select>
                        <br><input type="submit" value="Submit">
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="app/js/user.js"></script>
<script src="public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>