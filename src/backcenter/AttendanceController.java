package backcenter;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AttendanceDao;
import dao.AttendanceTeacherDao;
import daoImp.AttendanceDaoImpl;
import daoImp.AttendanceTeacherDaoImpl;
import domain.Course;
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
		String op = request.getParameter("op");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		AttendanceDao ATDao = new AttendanceDaoImpl();
		List<Course> allAvaCourseList = ATDao.getAllAvaCourse(id);
		request.setAttribute("allAvaCourseList", allAvaCourseList);
		if(op==null) {
	        request.getRequestDispatcher("app/student/attendance.jsp").forward(request, response); 
		}
		else if(op.equals("get_attendance")){
			String cid = request.getParameter("cid");
			int ccid = Integer.parseInt(cid);
			String key = request.getParameter("ramdonkey");
			AttendanceDao aDao = new AttendanceDaoImpl();
			int rs = aDao.attend(key,id,ccid);
	        System.out.println(rs);
	        if(rs==0) {
	        	request.setAttribute("message","Attendance fail");
	        }
	        else {
	        	request.setAttribute("message","Attendance success");
	        }
			request.getRequestDispatcher("app/student/attendance.jsp").forward(request, response);
		}
	}
}
