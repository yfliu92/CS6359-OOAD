<%@ page
        import="java.util.List, domain.Course"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<Course> list = (List<Course>) request.getAttribute("list");
    String updmsg = (String)request.getAttribute("updmsg");
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
<%@ include file="./app/shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="./app/shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container">
                <h1> ${message} !!! </h1>
                <h2> ${updmsg} </h2>
                <%if (list != null) { %>
                <h2>Current Courses</h2>
                <form name="cform" id="cform" action="StudentController" method=post>
                    <table class="table">
                        <thead class="thead-light">
                        <tr>
                            <th>Term</th>
                            <th>Course Num/Sec</th>
                            <th>Course Name</th>
                            <th>Instructor</th>
                            <th>Schedule</th>
                            <th>Location</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                            <%
                                for(Course c:list){%>
                            <tr>
                                <input style="display:none" name="id" value=<%=c.getCid() %>>
                                <th><%=c.getYear() + "-" + c.getSemester()%>
                                </th>
                                <th><%=c.getCno() + "." + c.getSno() %>
                                </th>
                                <th><%=c.getCname() %>
                                </th>
                                <th><%=c.getTeacher_name()%>
                                </th>
                                <th><%=c.getStime().substring(0,5) + "-" + c.getEtime().substring(0,5)%>
                                </th>
                                <th><%=c.getRoom()%>
                                </th>
                                <th><button type="submit" class="btn btn-primary" value="Detail" name="sbut" onclick="show(this)">Detail</button>
                                    <button type="button" class="btn btn-danger" value="Drop" name="dbut" onclick="drop(this)">Drop</button>
                                </th>
                            </tr>
                            <%} %>
                            <input type="text" name="selectid" value="" style="display:none">
                            <input type="text" name="op" value="" style="display:none">
                            <%} %>
                        </tbody>
                      </table>
                 </form>
            </div>
        </div>
    </div>
</main>

<script src="<%= basePath %>app/js/student.js"></script>
<script src="<%= basePath %>public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="<%= basePath %>app/js/welcome.js"></script>
</body>
</html>