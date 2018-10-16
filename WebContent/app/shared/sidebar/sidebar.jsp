<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    int userType = (int) request.getAttribute("userType");
%>
<%--userType == 0: admin--%>
<%--userType == 1: teacher--%>
<%--userType == 2: student--%>
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
        <a href="#" class="list-group-item list-group-item-action sidebar-home">teacher-home</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">teacher1</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">teacher2</a>
    </div>
    <%} else if (userType == 2) {%>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action sidebar-home">stuHome</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">student1</a>
    </div>
    <div class="list-group">
        <a href="#" class="list-group-item list-group-item-action">student2</a>
    </div>
    <%}%>
</div>