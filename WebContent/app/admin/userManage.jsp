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

    <link rel="stylesheet" href="<%= basePath %>public/css/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= basePath %>public/css/common.css">
    <link rel="stylesheet" href="<%= basePath %>app/styles/admin/admin.css">
</head>
<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container shadow-lg rounded">
                <div class="page-content-title border-bottom pt-3 pb-2 mb-3">
                    <h2>Add Users</h2>
                </div>
                <%if (request.getAttribute("message") != null) { %>
                <h2>${ message }</h2>
                <%} %>
                <form action="">
                    <table class="table table-striped">
                        <tbody>
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
                        </tbody>
                    </table>
                </form>
                <button class="btn btn-primary add-user-btn" type="button" value="Add User">Add User</button>
                <div id="add-user-form-area" class="addForm" style="display:none">
                    <form name="addform" method=post action="AddUserController">
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputUserName">User Name</label>
                                <input type="text" name="id" class="form-control" id="inputUserName"
                                       placeholder="User name">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputPassword">Password</label>
                                <input type="password" name="pwd" class="form-control" id="inputPassword"
                                       placeholder="Password">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputFistName">First Name</label>
                                <input type="text" name="fname" class="form-control" id="inputFistName"
                                       placeholder="First name">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputLastName">Last Name</label>
                                <input type="text" name="lname" class="form-control" id="inputLastName"
                                       placeholder="Last name">
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="inputSchool">School</label>
                                <input type="text" name="school" class="form-control" id="inputSchool"
                                       placeholder="School">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputYear">Year</label>
                                <input type="text" name="year" class="form-control" id="inputYear" placeholder="Year">
                            </div>
                        </div>
                        <%--<br>User ID: <input type="text" name="id">--%>
                        <%--<br>Password: <input type="text" name="pwd">--%>
                        <%--<br>First Name: <input type="text" name="fname">--%>
                        <%--<br>Last Name: <input type="text" name="lname">--%>
                        <%--<br>Email: <input type="text" name="email">--%>
                        <%--<br>School: <input type="text" name="school">--%>
                        <%--<br>Year: <input type="text" name="year">--%>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="user_type">User Type</label>
                                <select id="user_type" name="userType" class="custom-select">
                                    <option value=0>Admin</option>
                                    <option value=2>Teacher</option>
                                    <option value=1>Student</option>
                                </select>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="inputEmail">Email</label>
                                <input type="email" name="email" class="form-control" id="inputEmail"
                                       placeholder="Email">
                            </div>
                        </div>
                        <button class="btn btn-primary" type="submit" value="Submit">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
<script src="<%= basePath %>public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="<%= basePath %>app/js/admin.userManager.js"></script>
</body>
</html>