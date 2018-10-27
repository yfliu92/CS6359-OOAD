package backcenter;

import dao.CourseDao;
import dao.UserDao;
import daoImp.CourseDaoImpl;
import daoImp.UserDaoImpl;
import domain.Course;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacherController")
public class teacherController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public teacherController(){}
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String op = request.getParameter("op");
        HttpSession session=request.getSession();
        String teacher_id=session.getAttribute("id").toString();
        //loading
        if (op.equals("loading")) {
            CourseDao cDao = new CourseDaoImpl();
            List<Course> courseList=cDao.getCourseList(teacher_id);
            JSONArray jsonArray=new JSONArray();
            for(Course c:courseList){
                JSONObject jsonObject=new JSONObject();
                jsonObject.put("cId",c.getCid());
                jsonObject.put("cName",c.getCname());
                jsonArray.put(jsonObject);
            }
            response.getWriter().write(jsonArray.toString());
        }
        //get profile
        else if(op.equals("profile")){
            UserDao userDao=new UserDaoImpl();
            User user=userDao.getProfile(teacher_id);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",user.getId());
            jsonObject.put("firstName",user.getF_name());
            jsonObject.put("lastName",user.getL_name());
            jsonObject.put("email",user.getEmail());
            jsonObject.put("school",user.getSchool());
            jsonObject.put("year",user.getYear());
            response.getWriter().write(jsonObject.toString());
        }
        //get course information
        else if(op.equals("courseDetail")){
            String course_id=request.getParameter("courseId");
            CourseDao courseDao=new CourseDaoImpl();
            Course course=courseDao.getCourse(course_id);
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("cId",course.getCid());
            jsonObject.put("cName",course.getCname());
            jsonObject.put("prefix",course.getPrefix());
            jsonObject.put("courseNum",course.getCno());
            jsonObject.put("sectionNum",course.getSno());
            jsonObject.put("room",course.getRoom());
            jsonObject.put("capacity",course.getCapacity());
            jsonObject.put("year",course.getYear());
            jsonObject.put("semester",course.getSemester());
            jsonObject.put("startDay",course.getSday());
            jsonObject.put("endDay",course.getEday());
            jsonObject.put("days",course.getDays());
            jsonObject.put("startTime",course.getStime());
            jsonObject.put("endTime",course.getEtime());
            jsonObject.put("teacher",course.getTeacher_name());
            jsonObject.put("syllabus",course.getSyllabus_no());
            response.getWriter().write(jsonObject.toString());
        }
    }
}
