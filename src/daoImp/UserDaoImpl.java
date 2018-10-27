package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import backcenter.Login;
import dao.UserDao;
import db.DbManager;
import domain.User;

/**
* @author zxy
* @version Sep 30, 2018 5:07:19 PM
* 
*/
public class UserDaoImpl implements UserDao {
	static Connection conn;
	static PreparedStatement ps;
	DbManager db = new DbManager();
	
	@Override
	public int register(User user) {
		int status = 0;
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("insert into users values(?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getF_name());
			ps.setString(4, user.getL_name());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getSchool());
			ps.setString(7, user.getYear());
			ps.setString(8, "1");	
			status = ps.executeUpdate();
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public User validateUser(Login login) {
		User user = new User();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from users where id=? and password=?");
			ps.setString(1, login.getId());
			ps.setString(2, login.getPassword());

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setF_name(rs.getString(3));
				user.setUser_type(rs.getInt(8));
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return user;
	}

	@Override
	public User getProfile(String id) {
		User user=new User();
		try{
			conn = db.getConnection();
			ps =conn.prepareStatement("select * from users where id=?");
			ps.setString(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				user.setId(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setF_name(rs.getString(3));
				user.setL_name(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setSchool(rs.getString(6));
				user.setYear(rs.getString(7));
				user.setUser_type(rs.getInt(8));
			}
			conn.close();
		}catch(Exception e){
			System.out.println(e);
		}
		return user;
	}

}
