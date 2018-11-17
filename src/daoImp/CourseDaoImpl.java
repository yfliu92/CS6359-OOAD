package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.CourseDao;
import db.DbManager;
import domain.Course;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public class CourseDaoImpl implements CourseDao {
	public List<Course> getCourseList() {
		List<Course> list = new ArrayList<>();
		String sql = "select c.*, u.f_name,u.l_name from courses c left join Users u on c.teacher_id = u.id;";
		DbManager db = new DbManager();
		Connection conn = null;
		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Course c = new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setPrefix(rs.getString(3));
				c.setCno(rs.getString(4));
				c.setSno(rs.getString(5));
				c.setRoom(rs.getString(6));
				c.setCapacity(rs.getInt(7));
				c.setYear(rs.getString(8));
				c.setSemester(rs.getString(9));
				c.setSday(rs.getString(10));
				c.setEday(rs.getString(11));
				c.setDays(rs.getString(12));
				c.setStime(rs.getString(13));
				c.setEtime(rs.getString(14));
				c.setTeacher_id(rs.getString(15));
				c.setSyllabus_no(rs.getString(16));
				c.setTeacher_name(rs.getString(17)+" "+rs.getString(18));
				list.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	// get the course detail by course id
	@Override
	public Course getCourse(String id) {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		String sql = "select c.*,u.f_name,u.l_name from Courses c left join Users u on c.teacher_id = u.id where c.id = ?";
		conn = db.getConnection();
		Course c = new Course();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			c.setCid(rs.getInt(1));
			c.setCname(rs.getString(2));
			c.setPrefix(rs.getString(3));
			c.setCno(rs.getString(4));
			c.setSno(rs.getString(5));
			c.setRoom(rs.getString(6));
			c.setCapacity(rs.getInt(7));
			c.setYear(rs.getString(8));
			c.setSemester(rs.getString(9));
			c.setSday(rs.getString(10));
			c.setEday(rs.getString(11));
			c.setDays(rs.getString(12));
			c.setStime(rs.getString(13));
			c.setEtime(rs.getString(14));
			c.setTeacher_id(rs.getString(15));
			c.setSyllabus_no(rs.getString(16));
			c.setTeacher_name(rs.getString(17)+" "+rs.getString(18));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
		
	}

	// get current student number that has register this course
	@Override
	public int getStuNum(String id) {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		String sql = "select count(*) from stu_courses where course_id = ?;";
		conn = db.getConnection();
		int res = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			res = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	//get course name,id from teacher_id
	@Override
	public List<Course> getCourseList(String teacher_id) {
		List<Course> result=new ArrayList<>();
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from courses where teacher_id=?");
			ps.setString(1, teacher_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Course course=new Course();
				course.setCid(rs.getInt(1));
				course.setCname(rs.getString(2));
				result.add(course);
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return result;
	}

    @Override
    public List<Course> getCoursesByUserId(String userID) {
        List<Course> result=new ArrayList<>();
        Connection conn;
        PreparedStatement ps;
        DbManager db = new DbManager();
        // get course by user id
        try{
            conn = db.getConnection();
            ps =conn.prepareStatement("select course.* from COURSES course, STU_COURSES stu_c where stu_c.course_id=course.id and stu_c.stu_id=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course=new Course();
                course.setCid(rs.getInt(1));
                System.out.println(rs.getString(2));
                course.setCname(rs.getString(2));
                result.add(course);
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }

        // get course by teacher id
        try{
            conn = db.getConnection();
            ps =conn.prepareStatement("select * from courses where teacher_id=?");
            ps.setString(1, userID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Course course=new Course();
                course.setCid(rs.getInt(1));
                System.out.println(rs.getString(2));

                course.setCname(rs.getString(2));
                result.add(course);
            }
            conn.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return result;
    }


}
