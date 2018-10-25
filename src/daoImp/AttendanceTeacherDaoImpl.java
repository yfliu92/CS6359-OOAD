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
	public int setRK(String id, String rk) {
		int rs=0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("UPDATE ATTENDANCE_KEY SET ramdon_key =? ,attend_state =1 WHERE teacher_id =?");
			ps.setString(1, rk);
			ps.setString(2, id);
			rs = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return rs;
	}
	@Override
	public int endAttendance(String id) {
		int rs=0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("UPDATE ATTENDANCE_KEY SET attend_state =0 WHERE teacher_id =?");
			ps.setString(1, id);
			rs = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return rs;
	}
	@Override
	public List<User> showAbsence() {
		List<User> list = new ArrayList<>();
		String sql = "select u.id, u.f_name,u.l_name from Users u, ATTENDANCE a where u.id=a.stu_id and a.state=0;";
		DbManager db = new DbManager();
		Connection conn = null;
		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
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
	




}
