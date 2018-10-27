package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AttendanceDao;
import db.DbManager;
import domain.Course;
import domain.User;

/**
* @author zxy
* @version Oct 19, 2018 2:16:03 PM
* 
*/
public class AttendanceDaoImpl implements AttendanceDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public int attend(String key, String id,int cid) {
		int rs=0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from attendance_key where ramdon_key=? and course_id=? and attend_state=1");
			ps.setString(1, key);
			ps.setInt(2, cid);
			ResultSet r = ps.executeQuery();
			while(r.next()){
				ps =conn.prepareStatement("SELECT * FROM attendance WHERE stu_id=? AND course_id =?");
				ps.setString(1, id);
				ps.setInt(2, cid);
				ResultSet r2 = ps.executeQuery();
				if(r2.next()) {
					ps =conn.prepareStatement("update attendance set state=1 where stu_id=? and course_id=?");
					ps.setString(1, id);
					ps.setInt(2, cid);
					rs=ps.executeUpdate();
				}
				else {
					ps =conn.prepareStatement("insert into attendance (stu_id,course_id,day,state)  VALUES (?,?,'2008-01-01',1) ");
					ps.setString(1, id);
					ps.setInt(2, cid);
					rs=ps.executeUpdate();
				}
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return rs;
	}

	@Override
	public List<Course> getAllAvaCourse(String id) {
		List<Course> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			ps =conn.prepareStatement("SELECT a.course_id FROM ATTENDANCE_KEY a, STU_COURSES sc WHERE a.course_id=sc.course_id and a.attend_state =1");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Course c = new Course();
				c.setCid(rs.getInt(1));
//				System.out.println(c.getCid());
				list.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
