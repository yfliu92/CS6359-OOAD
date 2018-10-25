package backcenter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import daoImp.UserDaoImpl;
import domain.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public LoginController() {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserDao userDao = new UserDaoImpl();

        String id = request.getParameter("id");
        String pass = request.getParameter("password");
        String submitType = request.getParameter("submit");
        Login login = new Login(id, pass);
        User user = userDao.validateUser(login);
        HttpSession session = request.getSession();

        if (submitType.equals("login") && user != null && user.getId() != null) {
            session.setAttribute("id", user.getId());
            session.setAttribute("type", user.getUser_type());
            session.setAttribute("message", "Hello " + user.getId());

            if (session.getAttribute("type").equals(0)) {
                request.getRequestDispatcher("welcome.jsp").forward(request, response);
            } else if (session.getAttribute("type").equals(1)) {
                request.getRequestDispatcher("StudentController").forward(request, response);
            } else if (session.getAttribute("type").equals(2)) {
                request.getRequestDispatcher("app/teacher/teacherAttendance.jsp").forward(request, response);
            }
        } else if (submitType.equals("register")) {
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
        } else {
            request.setAttribute("message", "Data Not Found! Please register!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }

    }

}
