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
    <link rel="stylesheet" href="<%= basePath %>app/styles/admin/admin.css">
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
            <div class="col-md-10 page-content-container  shadow-lg rounded">
                <div class="page-content-title border-bottom pt-3 pb-2 mb-3">
                    <h2>Edit Course</h2>
                </div>
                <form name="form1" action="CourseController" method="post">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="year">Year</label>
                            <input type="text" name="year" class="form-control" id="year" placeholder="Year" onchange="changeyear()" value=<%=course.getYear() %> />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="semester">Semester</label>
                            <input type="text" name="semester" class="form-control" id="semester" placeholder="Semester" value=<%=course.getSemester() %> />
                        </div>
                    </div>
                    <%--<br>Year: <input type="text" name="year" onchange="changeyear()" style="width:50px">--%>
                    <%--<br>Semester: <input type="text" name="semester" style="width:70px">--%>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="prefix">Course Prefix</label>
                            <select id="prefix" class="custom-select" name="prefix" onclick="getPrefix()">
                                <option value=0>Select Course Prefix</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="number">Course Number</label>
                            <input type="text" name="cno" class="form-control" id="number" placeholder="Course Number" value=<%=course.getCno() %> />
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="sec">Section Number</label>
                            <input type="text" id="sec" name="sno" class="form-control" placeholder="Section Number" value=<%=course.getSno() %> />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="cname">Course Name</label>
                            <input type="text" name="cname" class="form-control" id="cname" placeholder="Course Name">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <%--<input type="text" name="syear" value=<%=course.getYear() %> style="display:none">--%>
                            <label>Start Date</label>
                            <select class="custom-select" name="smonth" onclick="getMonth(1)" onchange="getDay(1)">
                                <option value=0>Month</option>
                            </select>
                            <select class="custom-select" name="sday">
                                <option value=0>Day</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label>End Date</label>
                            <select class="custom-select" name="emonth" onclick="getMonth(0)" onchange="getDay(0)">
                                <option value=0>Month</option>
                            </select>
                            <select class="custom-select" name="eday">
                                <option value=0>Day</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="M" name="days" <%if (course.getDays().indexOf("M") != -1) { %>   checked="checked" <%} %> >Monday</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="Tu" name="days" <%if (course.getDays().indexOf("Tu") != -1) { %>   checked="checked" <%} %> >Tuesday</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="M" name="days" <%if (course.getDays().indexOf("W") != -1) { %>   checked="checked" <%} %> >Wednesday</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="M" name="days" <%if (course.getDays().indexOf("Th") != -1) { %>   checked="checked" <%} %> >Thursday</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="M" name="days" <%if (course.getDays().indexOf("F") != -1) { %>   checked="checked" <%} %> >Friday</label>
                            </div>
                        </div>
                        <div class="form-group col-md-2">
                            <div class="checkbox">
                                <label><input type="checkbox" value="M" name="days" <%if (course.getDays().indexOf("Sa") != -1) { %>   checked="checked" <%} %> >Saturday</label>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="s_time">Time</label>
                            <input type="text" name="stime" value=<%=stime %> />
                            <select id="s_time" name="ap1">
                                <option value="am" <%if (ap1.equals("am")) { %> selected="selected" <%} %> >AM</option>
                                <option value="pm" <%if (ap1.equals("pm")) { %> selected="selected" <%} %> >PM</option>
                            </select>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="e_time">To</label>
                            <input type="text" name="etime" value=<%=etime %> />
                            <select id="e_time" name="ap2">
                                <option value="am" <%if (ap2.equals("am")) { %> selected="selected" <%} %>>AM</option>
                                <option value="pm" <%if (ap2.equals("pm")) { %> selected="selected" <%} %>>PM</option>
                            </select>
                            <span>&nbsp;(format as 08:30)</span>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="room">Room</label>
                            <input type="text" name="room" class="form-control" id="room" placeholder="Room Number" value=<%=room %> />
                        </div>
                        <div class="form-group col-md-6">
                            <label for="capacity">Capacity</label>
                            <input type="text" name="capacity" class="form-control" id="capacity" placeholder="Capacity" value=<%=course.getCapacity() %> />
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="teacher">Instructor</label>
                            <select name="teacher" id="teacher" class="custom-select">
                                <%
                                    for (User u : list) {%>
                                <option value=<%=u.getId()%> <%if(course.getTeacher_id().equals(u.getId())){%> selected="selected" <%} %>><%=u.getF_name() + " " + u.getL_name() %>
                                </option>
                                <%} %>
                            </select>
                        </div>
                    </div>
                    <div class="row pt-1 pb-3">
                        <div class="col-md-3 d-flex">
                            <button type="submit" class="btn btn-success" value="Save">Save</button>
                        </div>
                    </div>
                    <input type="text" name="cid" value=<%=course.getCid()%> style="display:none">
                    <input type="text" name="op" value="add" style="display:none">
                    <input type="text" name="edit" value="yes" style="display:none">
                </form>

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
<script src="<%= basePath %>app/js/admin.editCourse.js"></script>

</body>
</html>