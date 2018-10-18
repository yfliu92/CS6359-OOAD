<%@ page
        import="java.util.List,daoImp.AdminDaoImpl,dao.AdminDao,domain.User,domain.Course"
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

    <link rel="stylesheet" href="<%= basePath %>public/css/normalize.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= basePath %>public/css/common.css">
</head>
<%
    Course course = (Course) request.getAttribute("course");
    String cname = course.getCname();
    while (cname.indexOf(" ") != -1) {
        cname = cname.substring(0, cname.indexOf(" ")) + "&nbsp;"
                + cname.substring(cname.indexOf(" ") + 1);
    }
    String room = course.getRoom();
    while (room.indexOf(" ") != -1) {
        room = room.substring(0, room.indexOf(" ")) + "&nbsp;"
                + room.substring(room.indexOf(" ") + 1);
    }
    String stime = course.getStime().substring(0, course.getStime().length() - 3);
    String etime = course.getEtime().substring(0, course.getEtime().length() - 3);
    String ap1 = "am";
    String ap2 = "am";
    int s1 = Integer.parseInt(stime.split(":")[0]);
//System.out.println(s1);
    if (s1 > 12) {
        stime = String.valueOf(s1 - 12) + ":" + stime.split(":")[1];
        ap1 = "pm";
    }
    int s2 = Integer.parseInt(etime.split(":")[0]);
//System.out.println(s2);
    if (s2 > 12) {
        etime = String.valueOf(s2 - 12) + ":" + etime.split(":")[1];
        ap2 = "pm";
    }

    AdminDao adao = new AdminDaoImpl();
    List<User> list = adao.getAllTeachers();
%>
<body onload="getValues('<%=course.getPrefix()%>','<%=course.getSday()%>','<%=course.getEday()%>')">
<%@ include file="../shared/header/header.jsp" %>
<main role="main">
    <div class="container">
        <div class="row">
            <%@ include file="../shared/sidebar/sidebar.jsp" %>
            <div class="col-md-10 page-content-container">
                <h1>Edit Course</h1>
                <form name="form1" action="CourseController" method=post>
                    <br>Year: <input type="text" name="year" value=<%=course.getYear() %> onchange="changeyear()"
                                     style="width:50px">
                    <br>Semester: <input type="text" name="semester"
                                         value=<%=course.getSemester() %> style="width:70px">
                    <br>Course Prefix: <select name="prefix">
                </select>
                    <br>Course Number: <input type="text" name="cno" value=<%=course.getCno() %> />
                    <br>Section Number: <input type="text" name="sno" value=<%=course.getSno() %> />
                    <br>Course Name: <input type="text" name="cname" value=<%=cname%> />
                    <br>Start_Date: <input type="text" name="syear" value=<%=course.getYear() %> style="display:none">
                    <select name="smonth" onclick="getMonth(1)" onchange="getDay(1)">
                        <option value=0>Month</option>
                    </select>
                    <select name="sday">
                        <option value=0>Day</option>
                    </select>
                    <br>End_Date: <input type="text" name="eyear" value=<%=course.getYear() %> style="display:none">
                    <select name="emonth" onclick="getMonth(0)" onchange="getDay(0)">
                        <option value=0>Month</option>
                    </select>
                    <select name="eday">
                        <option value=0>Day</option>
                    </select>
                    <br>Days:
                    <input type="checkbox" name="days" value="M" <%if (course.getDays().indexOf("M") != -1) { %>
                           checked="checked" <%} %> />Monday
                    <input type="checkbox" name="days" value="Tu" <%if (course.getDays().indexOf("Tu") != -1) { %>
                           checked="checked" <%} %>  />Tuesday
                    <input type="checkbox" name="days" value="W" <%if (course.getDays().indexOf("W") != -1) { %>
                           checked="checked" <%} %> />Wednesday
                    <input type="checkbox" name="days" value="Th" <%if (course.getDays().indexOf("Th") != -1) { %>
                           checked="checked" <%} %> />Thursday
                    <input type="checkbox" name="days" value="F" <%if (course.getDays().indexOf("F") != -1) { %>
                           checked="checked" <%} %> />Friday
                    <input type="checkbox" name="days" value="Sa" <%if (course.getDays().indexOf("Sa") != -1) { %>
                           checked="checked" <%} %> />Saturday
                    <input type="checkbox" name="days" value="Su" <%if (course.getDays().indexOf("Su") != -1) { %>
                           checked="checked" <%} %> />Sunday
                    <br>Time: <input type="text" name="stime" value=<%=stime %> style="width: 60px">
                    <select name="ap1">
                        <option value="am" <%if (ap1.equals("am")) { %> selected="selected" <%} %>>AM</option>
                        <option value="pm" <%if (ap1.equals("pm")) { %> selected="selected" <%} %>>PM</option>
                    </select>
                    to
                    <input type="text" name="etime" value=<%=etime %> style="width: 60px">
                    <select name="ap2">
                        <option value="am" <%if (ap2.equals("am")) { %> selected="selected" <%} %>>AM</option>
                        <option value="pm" <%if (ap2.equals("pm")) { %> selected="selected" <%} %>>PM</option>
                    </select>
                    <br>Room: <input type="text" name="room" value=<%=room %>/>
                    <br>Capacity: <input type="text" name="capacity" value=<%=course.getCapacity() %> />
                    <br>Instructor: <select name="teacher">
                    <% for (User u : list) {%>
                    <option value=<%=u.getId()%> <%if(course.getTeacher_id().equals(u.getId())){%> selected="selected" <%} %>><%=u.getF_name() + " " + u.getL_name() %>
                    </option>
                    <%} %>
                </select>
                    <br><input type="submit" value="Save"/>
                    <input type="text" name="cid" value=<%=course.getCid()%> style="display:none">
                    <input type="text" name="op" value="add" style="display:none">
                    <input type="text" name="edit" value="yes" style="display:none">
                </form>
            </div>
        </div>
    </div>
</main>
<script src="<%= basePath %>app/js/course.js"></script>
<script src="<%= basePath %>public/js/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
</body>
</html>