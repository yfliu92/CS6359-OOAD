package backcenter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import daoImp.AdminDaoImpl;
import domain.User;

/**
 * @author Jie Zheng
 * @version create date: Oct 17, 2018
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AdminDao adao = new AdminDaoImpl();
        String message = (String) request.getAttribute("message");
        //System.out.println(message);
        List<User> list = adao.getAllUsers();
        request.setAttribute("ulist", list);
        request.setAttribute("message", message);
        request.getRequestDispatcher( "app/admin/userManage.jsp").forward(request, response);
    }

}
