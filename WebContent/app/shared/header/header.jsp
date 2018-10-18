<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    int type = (int) session.getAttribute("type");
    String path2 = request.getContextPath();
    String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path2 + "/";
%>
<header>
    <nav class="navbar navbar-dark bg-dark">
        <div class="container">
            <a class="navbar-brand" href="#">
              <img src="<%=basePath2%>public/assets/imgs/log_logo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
              League Of Courses
            </a>
            <div class="nav-item dropdown">
              <a class="nav-link dropdown-toggle navbar-toggler-icon" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></a>
              <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                <a class="dropdown-item" href="<%=basePath2%>logout.jsp">logout</a>
              </div>
            </div>
        </div>
    </nav>
</header>
