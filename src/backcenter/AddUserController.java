package backcenter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import daoImp.AdminDaoImpl;

/**
 * Servlet implementation class AddUser
 */

/**
 * @author Jie Zheng
 * @version create date: Oct 17, 2018
 */
@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String school = request.getParameter("school");
        String year = request.getParameter("year");
        String email = request.getParameter("email");
        int userType = Integer.valueOf(request.getParameter("userType"));
        AdminDao adao = new AdminDaoImpl();
        String res = adao.addUser(id, pwd, fname, lname, email, school, year, userType);
        request.setAttribute("message", res);

        request.getRequestDispatcher("UserController").forward(request, response);
    }

}
