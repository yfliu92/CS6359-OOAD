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
        <a href="<%=basePath1%>UserController" class="list-group-item list-group-item-action">User Manage</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>CourseController" class="list-group-item list-group-item-action">Current Courses</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>AddCourseController" class="list-group-item list-group-item-action">Add Course</a>
    </div>
    <%} else if (userType == 1) {%>
    <div class="list-group">
        <a href="<%=basePath1%>StudentController" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="<%=basePath1%>app/student/searchCourse.jsp" class="list-group-item list-group-item-action">Find
        Course</a>
    </div>
    <%} else {%>

    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">teacher</a>
    </div>
    <%} %>
</div>