<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--userType == 0: admin--%>
<%--userType == 1: student--%>
<%--userType == 2: teacher--%>
<%
    int userType = (int) session.getAttribute("type");
    String path1 = request.getContextPath();
    String basePath1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path1 + "/";
%>
<div class="col-md-2 side-bar">
    <% if (userType == 0) {%>

    <div class="list-group">
        <a href="<%=basePath1%>welcome.jsp" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>UserController" class="list-group-item list-group-item-action admin-users">Users</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>CourseController"
           class="list-group-item list-group-item-action admin-courses">Courses</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>AddCourseController" class="list-group-item list-group-item-action admin-add-course">Add
            Course</a>
    </div>
    <%} else if (userType == 1) {%>
    <div class="list-group">
        <a href="<%=basePath1%>StudentController" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>app/student/searchCourse.jsp"
           class="list-group-item list-group-item-action student-find-course">Find
            Course</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>AttendanceController" class="list-group-item list-group-item-action student-attendance">Attendance</a>
    </div>
    <%} else {%>
    <div class="list-group">
        <a href="<%=basePath1%>app/teacher/teacher.jsp" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>AttendanceTeacherController"
           class="list-group-item list-group-item-action teacher-attendance">Attendance</a>
    </div>
    <div class="list-group">
        <p class="list-group-item list-group-item-action sidebar-profile">Profile</p>
    </div>
    <div class="list-group sidebar-course">
        <h6 class="list-group-item list-group-item-action">Course</h6>
    </div>
    <%} %>
</div>