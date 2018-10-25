package backcenter;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDao;
import daoImp.AttendanceDaoImpl;
import domain.User;

/**
* @author zxy
* @version Oct 13, 2018 2:45:00 PM
* 
*/
@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AttendanceController() {
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
		String id = (String) session.getAttribute("id");
		String key = request.getParameter("ramdonkey");
		AttendanceDao aDao = new AttendanceDaoImpl();
		User user = aDao.attend(key,id);
		String res = user.getId();
        System.out.println(res);
		request.setAttribute("message",res);
		request.getRequestDispatcher("app/student/attendance.jsp").forward(request, response);
//		if(request.getParameter("op")==null) {
//			HttpSession session = request.getSession();
//			String id = (String)session.getAttribute("id");
//			StudentDao sdao = new StudentDaoImpl();
//			List<Course> list = sdao.getStuCourse(id);
//			request.setAttribute("message", "Hello "+id);
//			request.setAttribute("list", list);
//			request.getRequestDispatcher("welcome.jsp").forward(request, response);
//		}
//		else if(request.getParameter("op").equals("search")) {
//			String year = request.getParameter("year");
//			String semester = request.getParameter("semester");
//			String prefix = request.getParameter("prefix");
//			String cno = request.getParameter("cno");
//			String sno = request.getParameter("sno");
//			String cname = request.getParameter("cname").replaceAll("[^\\p{ASCII}]", " ");
//			String tid = request.getParameter("teacher");
//			System.out.println(year+"--"+semester+"--"+prefix+"--"+cno+"--"+sno+"--"+cname+"--"+tid);
//			StudentDao sdao = new StudentDaoImpl();
//			sdao.searchCourse(cname, cno, sno, prefix, year, semester, tid);
			
//		}
	}
}
