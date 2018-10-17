<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"%>
<div class="col-md-2 side-bar">
  <% if((int)session.getAttribute("type")==0){%>
  
  <div class="list-group">
  <a href="#" class="list-group-item list-group-item-action sidebar-home">Home</a>
  </div>
  <div class="list-group">
  <a href="UserController" class="list-group-item list-group-item-action sidebar-home">User Manage</a>
  </div>
  <div class="list-group">
  <a href="CourseController" class="list-group-item list-group-item-action sidebar-home">Current Courses</a>
  </div>
  <div class="list-group">
  <a href="addCourse.jsp" class="list-group-item list-group-item-action sidebar-home">Add Course</a>
  </div>
  <%} else{%>
  
  <div class="list-group">
  <a href="StudentController" class="list-group-item list-group-item-action sidebar-home">Home</a>
  </div>
  <div class="list-group">
  <a href="searchCourse.jsp" class="list-group-item list-group-item-action sidebar-home">Find Course</a>
  </div>
  <%} %>
=======
         pageEncoding="UTF-8" %>
<%
    int userType = (int) request.getAttribute("userType");
%>
<%--userType == 0: admin--%>
<%--userType == 1: student--%>
<%--userType == 2: teacher--%>
<div class="col-md-2 side-bar">
    <%
        if (userType == 0) {
    %>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action sidebar-home">Home</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">admin1</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">admin2</a>
    </div>
    <%} else if (userType == 1) {%>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action sidebar-home">student-home</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">student1</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">student2</a>
    </div>
    <%} else if (userType == 2) {%>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action sidebar-home">teacherHome</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">teacher1</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">teacher2</a>
    </div>
    <%}%>
>>>>>>> 2f465595415ce86c61d97193049a1a57cb5d63e7
</div>