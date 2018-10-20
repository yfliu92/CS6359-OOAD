<%@ page
        import="java.util.List,daoImp.AdminDaoImpl,dao.AdminDao,domain.User,domain.Course"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    List<Course> clist = (List<Course>)request.getAttribute("clist");
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
            <div class="col-md-10 page-content-container">
                <h1>Search Course</h1>
                <form name="form1" action="StudentController" method=post>
                    <br>Year: <input type="text" name="year" onchange="changeyear()" style="width:50px">
                    <br>Semester: <input type="text" name="semester" style="width:70px">
                    <br>Course Prefix: <select name="prefix" onclick="getPrefix()">
                    <option value=0>Select Course Prefix</option>
                </select>
                    <br>Course Number: <input type="text" name="cno"/>
                    <br>Section Number: <input type="text" name="sno"/>
                    <br>Course Name: <input type="text" name="cname"/>
                    <br>Instructor: <select name="teacher">
                    <option value=-1>Any Instructor</option>
                    <% 
        			AdminDao adao = new AdminDaoImpl();
                    List<User> ulist = adao.getAllTeachers();
                    for (User u : ulist) {%>
                    <option value= <%=u.getId() %>><%=u.getF_name() + " " + u.getL_name() %>
                    </option>
                    <%} %>
                </select>
                    <br><input type="submit" value="Search Course"/>
                    <input type="text" name="op" value="search" style="display:none">
                </form>
                <%if(clist!=null){
                	if(clist.size()==0){%>
                <th>No course found!</th>
                <%}
                else{ %>
                <form name="cform" id="cform" action="StudentController" method=post>
                	<table>
                		<tr>
                            <th>Term</th>
                            <th>Course Section<br>Course Number
                            </th>
                            <th>Course Name</th>
                            <th>Instructor</th>
                            <th>Schedule & Location</th>
                            <th>Capacity</th>
                            <th>Action</th>
                        </tr>
                        <%
                                for (Course c : clist) {
                        %>
                        <tr>
                            <input style="display:none" name="id" value=<%=c.getCid() %>>
                            <th><%=c.getYear() + "-" + c.getSemester()%>
                            </th>
                            <th><%=c.getCno() + "." + c.getSno() %>
                            </th>
                            <th><%=c.getCname() %>
                            </th>
                            <th><%=c.getTeacher_name()%>
                            </th>
                            <th><%=c.getDays() + "  " + c.getStime() + "-" + c.getEtime() + "  " + c.getRoom()%>
                            </th>
                            <th><%=c.getCapacity() %>
                            </th>
                            <th><input type="submit" value="Detail" name="sbut" onclick="show(this)">
                            <input type="button" value="Register" name="rbut" onclick="reg(this)">
                            </th>
                        </tr>
                        <%
                                }
                        %>
                        <input type="text" name="selectid" value="" style="display:none">
                        <input type="text" name="op" value="" style="display:none">
                    </table>
                
                </form>
                <%} 
                }%>
            </div>
        </div>
    </div>
</main>
<script src="<%= basePath %>app/js/student.js"></script>
<script src="<%= basePath %>public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
<script src="<%= basePath %>app/js/course.js"></script>

</body>
</html>