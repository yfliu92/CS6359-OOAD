<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</div>