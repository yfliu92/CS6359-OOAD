package backcenter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDao;
import dao.StudentDao;
import daoImp.AdminDaoImpl;
import daoImp.StudentDaoImpl;
import domain.Course;
import domain.User;

/**
 * Servlet implementation class StudentController
 */


/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		StudentDao sdao = new StudentDaoImpl();
		if(request.getParameter("op")==null|| request.getAttribute("update")!=null) {
			List<Course> list = sdao.getStuCourse(id);
			request.setAttribute("message", "Hello "+id);
			request.setAttribute("list", list);
			System.out.println(list.size());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}
		else if(request.getParameter("op").equals("search")) {
			String year = request.getParameter("year");
			String semester = request.getParameter("semester");
			String prefix = request.getParameter("prefix");
			String cno = request.getParameter("cno");
			String sno = request.getParameter("sno");
			String cname = request.getParameter("cname").replaceAll("[^\\p{ASCII}]", " ");
			String tid = request.getParameter("teacher");
			List<Course> clist = sdao.searchCourse(cname, cno, sno, prefix, year, semester, tid);
			request.setAttribute("clist", clist);
			request.getRequestDispatcher("app/student/searchCourse.jsp").forward(request, response);
		}
		// student register the course
		else if(request.getParameter("op").equals("register")) {
			String cid = request.getParameter("selectid");
			System.out.println(cid+"---"+id);
			String msg = sdao.register(cid, id);
			request.setAttribute("update", "yes");
			request.setAttribute("updmsg", msg);
			request.getRequestDispatcher("StudentController").forward(request, response);
		}
	}

}
