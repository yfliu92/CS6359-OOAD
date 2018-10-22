package backcenter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import dao.CourseDao;
import daoImp.AdminDaoImpl;
import daoImp.CourseDaoImpl;
import domain.Course;


/**
 * @author Jie Zheng
 * @version create date: Oct 17, 2018
 */
@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseController() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        if (op == null || request.getAttribute("op1") != null) {
            String msg = (String) request.getAttribute("message");
            CourseDao cDao = new CourseDaoImpl();
            List<Course> list = cDao.getCourseList();
            request.setAttribute("courses", list);
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("app/admin/getAllCourses.jsp").forward(request, response);
        }
        // add course
        else if (op.equals("add")) {
            String year = request.getParameter("year");
            String semester = request.getParameter("semester");
            String prefix = request.getParameter("prefix");
            String cno = request.getParameter("cno");
            String sno = request.getParameter("sno");
            String cname = request.getParameter("cname").replaceAll("[^\\p{ASCII}]", " ");
            String sday = request.getParameter("year") + "-" + request.getParameter("smonth") + "-" + request.getParameter("sday");
            String eday = request.getParameter("year") + "-" + request.getParameter("emonth") + "-" + request.getParameter("eday");
            String[] dvalues = request.getParameterValues("days");
            String days = dvalues[0];
            for (int i = 1; i < dvalues.length; i++) {
                days += dvalues[i];
            }
            String t1 = request.getParameter("stime");
            String ap1 = request.getParameter("ap1");
            if (ap1.equals("pm") && Integer.valueOf(t1.split(":")[0]) < 12) {
                t1 = String.valueOf(Integer.valueOf(t1.split(":")[0]) + 12) + ":" + t1.split(":")[1];
            }
            String t2 = request.getParameter("etime");
            String ap2 = request.getParameter("ap2");
            if (ap2.equals("pm") && Integer.valueOf(t2.split(":")[0]) < 12) {
                t2 = String.valueOf(Integer.valueOf(t2.split(":")[0]) + 12) + ":" + t2.split(":")[1];
            }
            String room = request.getParameter("room").replaceAll("[^\\p{ASCII}]", " ");
            int capacity = Integer.valueOf(request.getParameter("capacity"));
            String tid = request.getParameter("teacher");

            System.out.println(cname + " ----- " + room);
            AdminDao adao = new AdminDaoImpl();
            int cid = 0;
            // operation is edit course
            if (request.getParameter("edit") != null) {
                cid = Integer.parseInt(request.getParameter("cid"));
            }
            String res = adao.addCourse(cname, prefix, cno, sno, room, capacity, year, semester, sday, eday, days, t1, t2, tid, cid);
            request.setAttribute("message", res);
            request.setAttribute("op1", "1");
            request.getRequestDispatcher("CourseController").forward(request, response);
        }
        // edit course
        else if (op.equals("edit")) {
            String id = request.getParameter("selectid");
            CourseDao cdao = new CourseDaoImpl();
            Course course = cdao.getCourse(id);
            request.setAttribute("course", course);
            request.getRequestDispatcher("app/admin/editCourse.jsp").forward(request, response);
        }
        // delete course
        else { // op.equals("del")
            int id = Integer.parseInt(request.getParameter("selectid"));
            AdminDao adao = new AdminDaoImpl();
            String msg = adao.delCourse(id);
            request.setAttribute("op1", "2");
            request.setAttribute("message", msg);
            request.getRequestDispatcher("CourseController").forward(request, response);
        }

    }

}
