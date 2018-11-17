<%@ page
        import="java.util.List,java.util.ArrayList,domain.Course"
        language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8" %>
<%@ page import="domain.Comment" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    int userType1 = (int) session.getAttribute("type");
    List<Comment> comments = (ArrayList) request.getAttribute("comments");
    List<Course> courses = (ArrayList) request.getAttribute("courses");
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
                <%--<h5> Courses </h5>--%>
                <%
                    if (userType1 == 1) {
                %>
                <div class="page-content-title border-bottom pt-3 pb-2 mb-3">
                    <h2>Make your comment!</h2>
                </div>
                <div id="create-comment-area" class="">
                    <div class="form-group">
                        <label for="comment-course-select">Select a course</label>
                        <select class="form-control" id="comment-course-select">
                            <%
                                for (int i = 0; i < courses.size(); i++) {
                                    Course course = courses.get(i);
                                    int courseId = course.getCid();
                                    String courseName = course.getCname();
                            %>
                            <option value="<%= courseId %>"><%= courseName %>
                            </option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="comment-rating">Rating</label>
                        <select name="rating" id="comment-rating">
                            <option value="0">0</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="comment-content">Comment</label>
                        <textarea class="form-control" id="comment-content" rows="3"></textarea>
                    </div>
                    <button class="btn btn-primary create-comment-button">submit</button>
                </div>
                <%}%>
                <div class="page-content-title border-bottom pt-3 pb-2 mb-3">
                    <h2>Comments</h2>
                </div>
                <div class="form-group">
                    <label for="course-filter">Select a course</label>
                    <select class="form-control" id="course-filter">
                        <option value="all">All</option>
                        <%
                            for (int i = 0; i < courses.size(); i++) {
                                Course course = courses.get(i);
                                int courseId = course.getCid();
                                String courseName = course.getCname();
                        %>
                        <option value="<%= courseId %>"><%= courseName %>
                        </option>
                        <%}%>
                    </select>
                </div>
                <%
                    for (int i = 0; i < comments.size(); i++) {
                        Comment c = comments.get(i);
                        int rating = c.getRating();
                        String content = c.getContent();
                        Course course = c.getCourse();
                        String courseName = course.getCname();

                %>
                <p><%= rating %>
                </p>

                <p><%= content %>
                </p>
                <p><%= courseName %>
                </p>
                <%
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
<script src="<%= basePath %>app/js/comments.js"></script>
</body>
</html>