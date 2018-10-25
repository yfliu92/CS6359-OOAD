package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.AttendanceDao;
import db.DbManager;
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
	public User attend(String key, String id) {
		User user = new User();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from attendance_key where ramdon_key=? and attend_state=1");
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
//			if(rs.next()) {
//				ps =conn.prepareStatement("update attendance set state=1 where stu_id=?");
//				ps.setString(1, id);
//				ps.executeUpdate();
//			}
			while(rs.next()){
				user.setId("success");
//				user.setPassword("12341234");
//				user.setF_name("12341234345");
//				user.setUser_type(1);
				ps =conn.prepareStatement("update attendance set state=1 where stu_id=?");
				ps.setString(1, id);
				ps.executeUpdate();
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return user;
	}

}
