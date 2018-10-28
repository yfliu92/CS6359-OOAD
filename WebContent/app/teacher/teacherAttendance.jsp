<%@ page
        import="domain.User,domain.Course,java.util.List"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String cid = (String) request.getAttribute("cid");
    List<User> AbsenceList = (List<User>) request.getAttribute("list");
    List<Course> allCourseList = (List<Course>) request.getAttribute("allCourseList");
    String ramdonKey = (String) request.getAttribute("ramdonKey");
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
                <div class="page-content-title border-bottom pt-3 pb-2 mb-3">
                    <h2>Attendance Statistics</h2>
                </div>
                <table class="table table-sm">
                    <thead class="thead-light">
                    <tr>
                        <th>Name</th>
                        <th>Course#</th>
                        <th>Section#</th>
                        <th>Get Attendance Key</th>
                        <th>End Attendance</th>
                        <th>Show Absence</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        if (allCourseList != null) {
                            for (Course c : allCourseList) {
                    %>
                    <tr>
                        <td><%=c.getCname()%>
                        </td>
                        <td><%=c.getCno()%>
                        </td>
                        <td><%=c.getSno()%>
                        </td>
                        <td>
                            <form action="AttendanceTeacherController" method="post">
                                <input class="btn btn-outline-success btn-sm" type="submit" value="Get Attendance Key"/>
                                <input type="text" name="cid" value="<%=c.getCid()%>" style="display:none"/>​
                                <input type="text" name="op" value="start" style="display:none">
                            </form>
                            <%
                                if (ramdonKey != null && cid != null) {
                                    int ccid = Integer.parseInt(cid);
                                    if (ccid == c.getCid()) {
                            %>
                            <p><%=ramdonKey%>
                            </p>

                            <%} %>
                            <%} %>
                        </td>
                        <td>
                            <form action="AttendanceTeacherController" method="post">
                                <input class="btn btn-outline-danger btn-sm" type="submit" value="End Attendance"/>
                                <input type="text" name="cid" value="<%=c.getCid()%>" style="display:none"/>​
                                <input type="text" name="op" value="end" style="display:none">
                            </form>
                        </td>
                        <td>
                            <form action="AttendanceTeacherController" method="post">
                                <input class="btn-outline-info" type="submit" value="Show Absence"/>
                                <input type="text" name="cid" value="<%=c.getCid()%>" style="display:none"/>​
                                <input type="text" name="op" value="show" style="display:none">
                            </form>
                            <%
                                if ((AbsenceList != null && AbsenceList.size() != 0) && cid != null) {
                                    int ccid = Integer.parseInt(cid);
                                    if (ccid == c.getCid()) {
                            %>
                            <h4>Absence List</h4>
                            <table class="table table-sm table-responsive">
                                <thead>
                                <tr>
                                    <th>Stu_id</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (User u : AbsenceList) {%>
                                <tr>
                                    <td><%=u.getId()%>
                                    </td>
                                    <td><%=u.getF_name() %>
                                    </td>
                                    <td><%=u.getL_name()%>
                                    </td>
                                </tr>
                                <%} %>
                                </tbody>
                            </table>
                            <%} %>
                            <%} %>
                        </td>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
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
<script src="<%= basePath %>app/js/teacher.attendance.js"></script>

</body>
</html>