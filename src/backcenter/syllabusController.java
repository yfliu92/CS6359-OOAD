package backcenter;


import dao.SyllabusDao;
import daoImp.SyllabusDaoImpl;
import domain.Syllabus;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/syllabusController")
public class syllabusController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public syllabusController(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //loading
        String op = request.getParameter("op");
        System.out.println(op);
        if(op.equals("loading")){
           String syllabusId=request.getParameter("syllabusId");
            System.out.println("syllabus"+syllabusId);
            request.setAttribute("syllabusId",syllabusId);
//            request.getRequestDispatcher("app/teacher/Syllabus.jsp").forward(request, response);
        }
        //syllabus detail
        else if(op.equals("syllabusDetail")){
            String syllabus_id=request.getParameter("syllabusId");
            SyllabusDao sDao=new SyllabusDaoImpl();
            Syllabus syllabus=sDao.getDetail(syllabus_id);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("taName",syllabus.getTaName());
            jsonObject.put("taEmail",syllabus.getTaEmail());
            jsonObject.put("description",syllabus.getDescription());
            jsonObject.put("grading",syllabus.getGrading());
            jsonObject.put("syllabus_id",syllabus.getSyllabusId());
            response.getWriter().write(jsonObject.toString());
        }
        else if(op.equals("update")){
            Syllabus syllabus=new Syllabus();
            syllabus.setSyllabusId(request.getParameter("syllabusId"));
            syllabus.setDescription(request.getParameter("description"));
            syllabus.setGrading(request.getParameter("grading"));
            syllabus.setTaName(request.getParameter("taName"));
            syllabus.setTaEmail(request.getParameter("taEmail"));
            SyllabusDao sDao=new SyllabusDaoImpl();
            int result=sDao.update(syllabus);
            JSONObject jsonObject=new JSONObject();
            System.out.println("result"+result);
            if(result==0){
                jsonObject.put("status",0);
            }
            else{
                jsonObject.put("status",1);
            }
            response.getWriter().write(jsonObject.toString());
        }
    }
}

