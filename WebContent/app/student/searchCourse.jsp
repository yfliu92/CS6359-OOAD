<%@ page
        import="java.util.List,daoImp.AdminDaoImpl,dao.AdminDao,domain.User,domain.Course"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<Course> clist = (List<Course>) request.getAttribute("clist");
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
                    <h2>Search Course</h2>
                </div>
                <form class="mb-3" name="form1" action="StudentController" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="year">Year</label>
                            <input type="text" name="year" onchange="changeyear()" class="form-control" id="year"
                                   placeholder="Year">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="semester">Semester</label>
                            <input type="text" name="semester" class="form-control" id="semester"
                                   placeholder="Semester">
                        </div>
                    </div>
                    <%--<br>Year: <input type="text" name="year" onchange="changeyear()" style="width:50px">--%>
                    <%--<br>Semester: <input type="text" name="semester" style="width:70px">--%>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="prefix">Course Prefix</label>
                            <select class="custom-select" id="prefix" name="prefix" onclick="getPrefix()">
                                <option value=0>Select Course Prefix</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="course_num">Course Number</label>
                            <input type="text" name="cno" class="form-control" id="course_num"
                                   placeholder="Course Number">
                        </div>
                    </div>
                    <%--<br>Course Prefix: <select name="prefix" onclick="getPrefix()">--%>
                    <%--<option value=0>Select Course Prefix</option>--%>
                    <%--</select>--%>
                    <%--<br>Course Number: <input type="text" name="cno"/>--%>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="sec_num">Section Number</label>
                            <input type="text" name="sno" class="form-control" id="sec_num"
                                   placeholder="Section Number">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="course_name">Course Name</label>
                            <input type="text" name="cname" class="form-control" id="course_name"
                                   placeholder="Course Name">
                        </div>
                    </div>
                    <%--<br>Section Number: <input type="text" name="sno"/>--%>
                    <%--<br>Course Name: <input type="text" name="cname"/>--%>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="instructor">Instructor</label>
                            <select name="teacher" id="instructor" class="custom-select">
                                <option value=-1>Any Instructor</option>
                                <%
                                    AdminDao adao = new AdminDaoImpl();
                                    List<User> ulist = adao.getAllTeachers();
                                    for (User u : ulist) {%>
                                <option value= <%=u.getId() %>><%=u.getF_name() + " " + u.getL_name() %>
                                </option>
                                <%} %>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="col-md-6">
                            <button type="submit" name="submit" value="Search Course" class="btn btn-outline-dark">Search
                                Course
                            </button>
                        </div>
                    </div>
                    <%--<br>Instructor: <select name="teacher">--%>
                    <%--<option value=-1>Any Instructor</option>--%>
                    <%--<% --%>
                    <%--AdminDao adao = new AdminDaoImpl();--%>
                    <%--List<User> ulist = adao.getAllTeachers();--%>
                    <%--for (User u : ulist) {%>--%>
                    <%--<option value= <%=u.getId() %>><%=u.getF_name() + " " + u.getL_name() %>--%>
                    <%--</option>--%>
                    <%--<%} %>--%>
                    <%--</select>--%>
                    <%--<br><input type="submit" value="Search Course"/>--%>
                    <input type="text" name="op" value="search" style="display:none">
                </form>

                <%
                    if (clist != null) {
                        if (clist.size() == 0) {
                %>
                <th>No course found!</th>
                <%} else { %>
                <form name="cform" id="cform" action="StudentController" method="post">
                    <table class="table table-sm">
                        <thead class="thead-light">
                        <tr>
                            <th>Term</th>
                            <th>Course Num/Sec</th>
                            <th>Course Name</th>
                            <th>Instructor</th>
                            <th>Schedule</th>
                            <th>Location</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            for (Course c : clist) {
                        %>
                        <tr>
                            <input style="display:none" name="id" value=<%=c.getCid() %>>
                            <td><%=c.getYear() + "-" + c.getSemester()%>
                            </td>
                            <td><%=c.getCno() + "." + c.getSno() %>
                            </td>
                            <td><%=c.getCname() %>
                            </td>
                            <td><%=c.getTeacher_name()%>
                            </td>
                            <td><%=c.getStime().substring(0, 5) + "-" + c.getEtime().substring(0, 5)%>
                            </td>
                            <td><%=c.getRoom()%>
                            </td>
                            <td>
                                <button type="button" class="btn btn-info btn-sm detail-btn" value="Detail"
                                        data-course-id="<%=c.getCid()%>">Detail
                                </button>
                                <button type="button" class="btn btn-outline-success btn-sm reg-btn" value="Register"
                                        data-course-id="<%=c.getCid()%>">Register
                                </button>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                        <input id="select-id-input" type="text" name="selectid" value="" style="display:none">
                        <input id="op-input" type="text" name="op" value="" style="display:none">
                        </tbody>
                    </table>

                </form>
                <%
                        }
                    }
                %>
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
<script src="<%= basePath %>app/js/course.js"></script>
<script src="<%= basePath %>app/js/student.js"></script>
<script src="<%= basePath %>app/js/student.findCourse.js"></script>
</body>
</html>