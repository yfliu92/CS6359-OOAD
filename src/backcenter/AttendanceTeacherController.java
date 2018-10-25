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
//        System.out.println(op);
        if(op.equals("start")) {
    		StringBuilder rk=new StringBuilder();
    	    for(int i=0;i<4;i++){
    	    	rk.append((int)(Math.random()*9)); 
    	       }
    	    System.out.println(rk);
    		ATDao.setRK(id,rk.toString());
    	    request.setAttribute("ramdonKey", rk.toString());
            request.getRequestDispatcher("app/student/teacherAttendance.jsp").forward(request, response);
        }
        else if(op.equals("end")) {
        	int i = ATDao.endAttendance(id);
        	System.out.println(i);
            request.getRequestDispatcher("app/student/teacherAttendance.jsp").forward(request, response);
        }
        else if(op.equals("show")) {
        	List<User> list = ATDao.showAbsence();
        	request.setAttribute("list", list);
            request.getRequestDispatcher("app/student/teacherAttendance.jsp").forward(request, response);
        }

	}
}
