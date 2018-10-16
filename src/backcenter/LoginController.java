package backcenter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import daoImp.UserDaoImpl;
import domain.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {}
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDaoImpl();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String submitType = request.getParameter("submit");
		Login login = new Login(id, pass);
		User user = userDao.validateUser(login);
		
		if(submitType.equals("login") && user!=null && user.getId()!=null){
			request.setAttribute("message", "Hello "+user.getId());
			request.setAttribute("userType", user.getUser_type());
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else if(submitType.equals("register")){
			user.setF_name(request.getParameter("name"));
			user.setId(request.getParameter("id"));
			user.setPassword(request.getParameter("password"));
			user.setF_name(request.getParameter("f_name"));
			user.setL_name(request.getParameter("l_name"));
			user.setEmail(request.getParameter("email"));
			user.setSchool(request.getParameter("school"));
			user.setYear(request.getParameter("year"));
			userDao.register(user);
			request.setAttribute("successMessage", "Registration done, please login!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			request.setAttribute("message", "Data Not Found! Please register!");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

}
