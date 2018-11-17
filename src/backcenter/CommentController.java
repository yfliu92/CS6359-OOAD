package backcenter;

import dao.CommentDao;
import dao.CourseDao;
import daoImp.CommentDaoImpl;
import daoImp.CourseDaoImpl;
import domain.Comment;
import domain.Course;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("id");
        CommentDao cd = new CommentDaoImpl();
        CourseDao courseDao = new CourseDaoImpl();

        //operation: get ---->  type: all,
        String operation = request.getParameter("operation");
        if (operation == null) {
            // when operating is null, or operation is "getAll", the code does exactly the same work
            List<Comment> results = cd.getAll(userId);
            List<Course> courses = courseDao.getCoursesByUserId(userId);

            // set comments and courses, read in the jsp file
            request.setAttribute("comments", results);
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("app/student/studentComments.jsp").forward(request, response);
        } else if ("create".equals(operation)) {
            // communicate with an AJAX request, will not reload the full page
            Comment comment = new Comment();
            comment.setUserId(userId);
            comment.setContent(request.getParameter("content"));
            comment.setRating(Integer.parseInt(request.getParameter("rating")));
            Course course = new Course();
            course.setCid(Integer.parseInt(request.getParameter("courseId")));
            comment.setCourse(course);

            int status = cd.createComment(comment);

            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            HashMap ret = new HashMap();
            ret.put("status", status);
            JSONObject responseJSONObject = new JSONObject(ret);


            PrintWriter out = response.getWriter();

            out.println(responseJSONObject);

        } else if ("getComments".equals(operation)) {
//             when the operating is "getComments", only need the parameters to be like
//            {
//                operation: "getComments",
//                courseId: "123"
//            }
            String courseId = request.getParameter("courseId");
            List<Comment> results = cd.getCommentsByCourse(courseId);
            List<Course> courses = courseDao.getCoursesByUserId(userId);

            request.setAttribute("comments", results);
            request.setAttribute("courses", courses);

            request.getRequestDispatcher("app/student/studentComments.jsp").forward(request, response);

        } else if ("getAll".equals(operation)) {
//             when the operating is "getAll", only need the parameters to be like
//            {
//                operation: "getAll"
//            }
            List<Comment> results = cd.getAll(userId);
            List<Course> courses = courseDao.getCoursesByUserId(userId);

            request.setAttribute("comments", results);
            request.setAttribute("courses", courses);
            request.getRequestDispatcher("app/student/studentComments.jsp").forward(request, response);
        }


    }
}
