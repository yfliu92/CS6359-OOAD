package backcenter;

import dao.CommentDao;
import daoImp.CommentDaoImpl;
import domain.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String studentId = (String) session.getAttribute("id");

        //operation: get ---->  type: all,
        String op = request.getParameter("op");
        if (op == null) {

            CommentDao cd = new CommentDaoImpl();
            List<Comment> results = cd.getAll(studentId);
            for (Comment c : results) {
                System.out.println(c.getContent());
            }
            request.setAttribute("comments", results);
            request.getRequestDispatcher("app/student/studentComments.jsp").forward(request, response);
        }


    }
}
