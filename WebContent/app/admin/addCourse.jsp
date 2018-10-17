<%@ page
        import="java.util.List,daoImp.AdminDaoImpl,dao.AdminDao,domain.User"
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

    <link rel="stylesheet" href="public/css/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="public/css/common.css">
</head>
<body>
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container">
                <h1>Add Course</h1>
                <form name="form1" action="CourseController" method=post>
                    <br>Year: <input type="text" name="year" onchange="changeyear()" style="width:50px">
                    <br>Semester: <input type="text" name="semester" style="width:70px">
                    <br>Course Prefix: <select name="prefix" onclick="getPrefix()">
                    <option value=0>Select Course Prefix</option>
                </select>
                    <br>Course Number: <input type="text" name="cno"/>
                    <br>Section Number: <input type="text" name="sno"/>
                    <br>Course Name: <input type="text" name="cname"/>
                    <br>Start_Date: <input type="text" name="syear" style="display:none">
                    <select name="smonth" onclick="getMonth(1)" onchange="getDay(1)">
                        <option value=0>Month</option>
                    </select>
                    <select name="sday">
                        <option value=0>Day</option>
                    </select>
                    <br>End_Date: <input type="text" name="eyear" style="display:none">
                    <select name="emonth" onclick="getMonth(0)" onchange="getDay(0)">
                        <option value=0>Month</option>
                    </select>
                    <select name="eday">
                        <option value=0>Day</option>
                    </select>
                    <br>Days:
                    <input type="checkbox" name="days" value="M"/>Monday
                    <input type="checkbox" name="days" value="Tu"/>Tuesday
                    <input type="checkbox" name="days" value="W"/>Wednesday
                    <input type="checkbox" name="days" value="Th"/>Thursday
                    <input type="checkbox" name="days" value="F"/>Friday
                    <input type="checkbox" name="days" value="Sa"/>Saturday
                    <input type="checkbox" name="days" value="Su"/>Sunday
                    <br>Time: <input type="text" name="stime" style="width: 60px"><select name="ap1">
                    <option value="am">AM</option>
                    <option value="pm">PM</option>
                </select>
                    to
                    <input type="text" name="etime" style="width: 60px"><select name="ap2">
                    <option value="am">AM</option>
                    <option value="pm">PM</option>
                </select> #format as 08:30
                    <br>Room: <input type="text" name="room"/>
                    <br>Capacity: <input type="text" name="capacity"/>
                    <br>Instructor: <select name="teacher">
                    <% AdminDao adao = new AdminDaoImpl();
                        List<User> list = adao.getAllTeachers();
                        for (User u : list) {%>
                    <option value= <%=u.getId() %>><%=u.getF_name() + " " + u.getL_name() %>
                    </option>
                    <%} %>
                </select>
                    <br><input type="submit" value="Add Course"/>
                    <input type="text" name="op" value="add" style="display:none">
                </form>
            </div>
        </div>
    </div>
</main>
<script src="app/js/course.js"></script>
<script src="public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="app/js/welcome.js"></script>
</body>
</html>