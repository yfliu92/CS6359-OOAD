<%@ page
        import="domain.User,java.util.List"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
        
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<User> list = (List<User>) request.getAttribute("list");
    String ramdonKey = (String)request.getAttribute("ramdonKey");
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
</head>
<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container">
            <form action="AttendanceTeacherController" method="post">
            <input type="submit" value="Get Attendance Key"/>
            <input type="text" name="op" value="start" style="display:none">
            </form>
            <%if (ramdonKey != null) { %>
            <p><%=ramdonKey%></p>
            <%} %>
            
            <br/>
            <form action="AttendanceTeacherController" method="post">
            <input type="submit" value="End Attendance"/>
            <input type="text" name="op" value="end" style="display:none">
            </form>
            <br/>
            
            <form action="AttendanceTeacherController" method="post">
            <input type="submit" value="Show Absence"/>
            <input type="text" name="op" value="show" style="display:none">
            </form>
            <%if (list != null) { %>
            <h2>Absence List</h2>
            <table>
                        <tr>
                        	<th>Stu_id</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                        </tr>
                            <%
			for(User u:list){%>
                        <tr>
                            <input style="display:none" name="id" value=<%=u.getId() %>>
                            <th><%=u.getId()%>
                            </th>
                            <th><%=u.getF_name() %>
                            </th>
                            <th><%=u.getL_name()%>
                            </th>
                        </tr>
                            <%} %>
            </table>
            <%} %>
            
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
<%-- <script src="<%= basePath %>app/js/course.js"></script> --%>

</body>
</html>