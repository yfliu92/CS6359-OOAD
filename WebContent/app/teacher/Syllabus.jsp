<%--
  Created by IntelliJ IDEA.
  User: weisen_cheng
  Date: 2018/10/23
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page
        import="java.util.List, domain.Course, domain.User"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    String updmsg = (String)request.getAttribute("updmsg");
    String syllabus_id=request.getParameter("id");
    System.out.println("next"+syllabus_id);
    System.out.println("base"+basePath);
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
    <%--<script type="application/javascript" src="<%= basePath %>app/js/teacher.js"></script>--%>
</head>

<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">

        <h2 id="syllabus_id" value="<%= syllabus_id %>"></h2>
            <p>Description</p>
            <textarea name="description" id="description" cols="200" rows="5"></textarea>
            <p>TA Name</p>
            <input type="text" id="taName">
            <p>TA Email</p>
            <input type="text" id="taEmail">
            <p>Grading</p>
            <textarea id="grading"  cols="200" rows="5"></textarea>
        <button id="submit">Update</button>
    </div>
</main>
<script src="<%= basePath %>public/js/jquery.min.js"></script>
<script src="<%= basePath %>app/js/syllabus.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

</body>
</html>