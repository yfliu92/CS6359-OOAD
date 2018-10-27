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
* @version Oct 20, 2018 9:52:36 PM
* 
*/
@WebServlet("/AttendanceTeacherController")
public class AttendanceTeacherController extends HttpServlet{
	private static final long serialVersionUID = 1L;

    public AttendanceTeacherController() {
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
		String id = (String)session.getAttribute("id");
		AttendanceTeacherDao ATDao = new AttendanceTeacherDaoImpl();
		List<Course> allCourseList = ATDao.getAllCourse(id);
		request.setAttribute("allCourseList", allCourseList);
		if(op==null) {
	        request.getRequestDispatcher("app/teacher/teacherAttendance.jsp").forward(request, response); 
		}
		else if(op.equals("start")) {
			String cid = request.getParameter("cid");
//			System.out.println(cid);
			int ccid = Integer.parseInt(cid);
    		StringBuilder rk=new StringBuilder();
    	    for(int i=0;i<4;i++){
    	    	rk.append((int)(Math.random()*9)); 
    	       }
    	    System.out.println(rk);
    		ATDao.setRK(id,rk.toString(),ccid);
    	    request.setAttribute("ramdonKey", rk.toString());
    	    request.setAttribute("cid", cid);
            request.getRequestDispatcher("app/teacher/teacherAttendance.jsp").forward(request, response);
        }
        else if(op.equals("end")) {
			String cid = request.getParameter("cid");
			int ccid = Integer.parseInt(cid);
        	int i = ATDao.endAttendance(id,ccid);
//        	System.out.println(i);
    	    request.setAttribute("cid", cid);
            request.getRequestDispatcher("app/teacher/teacherAttendance.jsp").forward(request, response);
        }
        else if(op.equals("show")) {
        	String cid = request.getParameter("cid");
        	int ccid = Integer.parseInt(cid);
        	List<User> list = ATDao.showAbsence(ccid);
        	request.setAttribute("list", list);
    	    request.setAttribute("cid", cid);
            request.getRequestDispatcher("app/teacher/teacherAttendance.jsp").forward(request, response);
        }

	}
}
