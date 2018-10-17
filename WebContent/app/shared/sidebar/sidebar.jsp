<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--userType == 0: admin--%>
<%--userType == 1: student--%>
<%--userType == 2: teacher--%>
<%
    int type = (int) session.getAttribute("type");
%>
<div class="col-md-2 side-bar">
    <% if (type == 0) {%>

    <div class="list-group">
        <a href="welcome.jsp" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="UserController" class="list-group-item list-group-item-action">User Manage</a>
    </div>
    <div class="list-group">
        <a href="CourseController" class="list-group-item list-group-item-action">Current Courses</a>
    </div>
    <div class="list-group">
        <a href="addCourse.jsp" class="list-group-item list-group-item-action">Add Course</a>
    </div>
    <%} else if (type == 1) {%>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">student</a>
    </div>

    <%} else {%>

    <div class="list-group">
        <a href="StudentController" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="searchCourse.jsp" class="list-group-item list-group-item-action">Find Course</a>
    </div>
    <%} %>
</div>