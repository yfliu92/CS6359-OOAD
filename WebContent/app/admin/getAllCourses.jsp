<%@ page
        import="java.util.List,java.util.ArrayList,domain.Course"
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
</head>
<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container shadow-lg rounded">
                <%--<h5> Courses </h5>--%>
                <h1 class="display-4">Courses</h1>
                <%if (request.getAttribute("message") != null) { %>

                <h2>
                    <%=request.getAttribute("message") %>
                </h2>

                <%} %>
                <form name="cform" action="CourseController">
                    <table class="table  table-sm table-hover">
                        <thead class="thead-light">
                        <tr>
                            <th>Term</th>
                            <th>Course#</th>
                            <th>Name</th>
                            <th>Inst.</th>
                            <th>Schedule</th>
                            <th>Location</th>
                            <th>Capacity</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Course> list = (ArrayList) request.getAttribute("courses");
                            if (list.size() > 0) {
                                for (Course c : list) {
                        %>
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
                            <th><%=c.getStime().substring(0, 5) + "-" + c.getEtime().substring(0, 5)%>
                            </th>
                            <th>
                                <%=c.getRoom()%>
                            </th>
                            <th><%=c.getCapacity() %>
                            </th>
                            <th>
                                <button type="submit" class="btn btn-success btn-sm" value="Edit" name="ebut"
                                        onclick="edit(this)"> &nbsp Edit &nbsp
                                </button>
                                <button type="submit" class="btn btn-danger btn-sm" value="Delete" name="dbut"
                                        onclick="del(this)">Delete
                                </button>
                            </th>
                        </tr>
                        <%
                                }
                            }
                        %>
                        </tbody>
                        <input type="text" name="selectid" value="" style="display:none">
                        <input type="text" name="op" value="" style="display:none">
                    </table>
                </form>
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
<script src="<%= basePath %>app/js/course.js"></script>
<script src="<%= basePath %>app/js/admin.courses.js"></script>
</body>
</html>