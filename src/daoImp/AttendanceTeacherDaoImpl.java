package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.AttendanceDao;
import dao.AttendanceTeacherDao;
import db.DbManager;
import domain.Course;
import domain.User;

/**
* @author zxy
* @version Oct 19, 2018 2:16:03 PM
* 
*/
public class AttendanceTeacherDaoImpl implements AttendanceTeacherDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	@Override
	public int setRK(String id, String rk, int cid) {
		int rs=0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("SELECT * FROM ATTENDANCE_KEY WHERE teacher_id =? AND course_id =?");
			ps.setString(1, id);
			ps.setInt(2, cid);
			ResultSet r = ps.executeQuery();
			if(r.next()) {
				ps =conn.prepareStatement("UPDATE ATTENDANCE_KEY SET ramdon_key =? ,attend_state =1 WHERE teacher_id =? and course_id=?");
				ps.setString(1, rk);
				ps.setString(2, id);
				ps.setInt(3, cid);
				rs = ps.executeUpdate();
			}
			else {
				ps =conn.prepareStatement("INSERT INTO ATTENDANCE_KEY (teacher_id, course_id, att_section_no, ramdon_key, attend_state) VALUES (?,?,'002',?,'1')");
				ps.setString(1, id);
				ps.setInt(2, cid);
				ps.setString(3, rk);
				rs = ps.executeUpdate();
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return rs;
	}
	@Override
	public int endAttendance(String id, int cid) {
		int rs=0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("UPDATE ATTENDANCE_KEY SET attend_state =0 WHERE teacher_id =? and course_id=?");
			ps.setString(1, id);
			ps.setInt(2, cid);
			rs = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return rs;
	}
	@Override
	public List<User> showAbsence(int cid) {
		List<User> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			ps =conn.prepareStatement("select u.id, u.f_name,u.l_name from Users u, ATTENDANCE a where u.id=a.stu_id and a.state=0 and course_id=?;");
			ps.setInt(1, cid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User u = new User();
				u.setId(rs.getString(1));
				u.setF_name(rs.getString(2));
				u.setL_name(rs.getString(3));
				list.add(u);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}
	@Override
	public List<Course> getAllCourse(String id) {
		List<Course> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			ps =conn.prepareStatement("SELECT * FROM COURSES WHERE teacher_id =?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Course c = new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setCno(rs.getString(4));
				c.setSno(rs.getString(5));
				list.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}	

}
