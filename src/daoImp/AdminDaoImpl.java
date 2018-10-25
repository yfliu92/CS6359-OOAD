package daoImp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import dao.AdminDao;
import db.DbManager;
import domain.Course;
import domain.User;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public class AdminDaoImpl implements AdminDao {


	@SuppressWarnings("resource")
	@Override
	public String addCourse(String cname, String prefix, String cno, String sno, String room, int capacity,
			String year, String semester, String sday, String eday, String days, String stime, String etime,
			String teacherid,int cid) {
			Connection conn;
			PreparedStatement ps;
			DbManager db = new DbManager();
			try{
				
				//
				if(cid==0) {
					conn = db.getConnection();
					ps = conn.prepareStatement("select count(id) from courses where prefix = ? and course_no=? and section_no=? and year=? and semester=?;");
					ps.setString(1, prefix);
					ps.setString(2, cno);
					ps.setString(3, sno);
					ps.setString(4, year);
					ps.setString(5, semester);
					ResultSet rs = ps.executeQuery();
					rs.next();
					int n = rs.getInt(1);
					if(n>0){
						return "There exists the same course in LOC!";
					}
					int syllabusNo = insertSyllabus();
					ps = conn.prepareStatement("Insert into courses(course_name,prefix,course_no,section_no,room,capacity,year,semester,start_day,end_day,days,start_time,end_time,teacher_id,syllabus_no) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
					ps.setString(1, cname);
					ps.setString(2, prefix);
					ps.setString(3, cno);
					ps.setString(4, sno);
					ps.setString(5, room);
					ps.setInt(6, capacity);
					ps.setString(7, year);
					ps.setString(8, semester);
					ps.setString(9, sday);
					ps.setString(10, eday);
					ps.setString(11, days);
					ps.setString(12, stime);
					ps.setString(13, etime);
					ps.setString(14, teacherid);
					ps.setInt(15, syllabusNo);
					int status = ps.executeUpdate();
					if(status==1) {
						return "Course succeed added!";
					}
				}
				else {
					conn = db.getConnection();
					String sql = "update courses set course_name=?, prefix=?,course_no=?,section_no=?,room=?,capacity=?,year=?,semester=?,start_day=?,end_day=?,days=?,start_time=?,end_time=?,teacher_id=? where id=?;";
					ps = conn.prepareStatement(sql);
					ps.setString(1, cname);
					ps.setString(2, prefix);
					ps.setString(3, cno);
					ps.setString(4, sno);
					ps.setString(5, room);
					ps.setInt(6, capacity);
					ps.setString(7, year);
					ps.setString(8, semester);
					ps.setString(9, sday);
					ps.setString(10, eday);
					ps.setString(11, days);
					ps.setString(12, stime);
					ps.setString(13, etime);
					ps.setString(14, teacherid);
					ps.setInt(15, cid);
					int status = ps.executeUpdate();
					if(status==1) {
						return "Course succeed edited!";
					}
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			return "Error Occurred!";
	}

	@Override
	public String delCourse(int courseid) {
		String sql = "select count(*) from stu_courses where course_id=?;";
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try {
		conn = db.getConnection();
		ps = conn.prepareStatement(sql);
		ps.setInt(1, courseid);
		ResultSet rs = ps.executeQuery();
		rs.next();
		int n = rs.getInt(1);
		if(n>0) {
			return "Students have enrolled in this course and course can not be deleted!";
		}
		String delsql = "delete from courses where id = ?;";
		conn = db.getConnection();
		ps=conn.prepareStatement(delsql);
		ps.setInt(1, courseid);
		int status = ps.executeUpdate();
		if(status==1) {
			return "Course has been deleted!";
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error Occurred!";
	}

	@Override
	public boolean updateCourse(int courseid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int insertSyllabus() {
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		conn = db.getConnection();
		int res = 0;
		try {
			ps = conn.prepareStatement("Insert into Syllabus(ta_name,ta_email,col_1,col_2) values(?,?,?,?);");
			ps.setString(1, null);
			ps.setString(2, null);
			ps.setString(3, null);
			ps.setString(4, null);
			ps.executeUpdate();
			
			ps = conn.prepareStatement("select max(id) from Syllabus;");
			ResultSet rs = ps.executeQuery();
			rs.next();
			res = rs.getInt(1);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "select * from Users;";
		DbManager db = new DbManager();
		Connection conn = null;
		List<User> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setF_name(rs.getString(3));
				user.setL_name(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setSchool(rs.getString(6));
				user.setYear(rs.getString(7));
				user.setUser_type(rs.getInt(8));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public String addUser(String id, String pwd, String fname, String lname, String email, String school, String year, int type) {
		String sql = "select count(id) from Users where id = ?;";
		Connection conn;
		PreparedStatement ps;
		DbManager db = new DbManager();
		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			int n = rs.getInt(1);
			if(n>0){
				return "User with id:"+id+" has already existed.";
			}
			}
			sql = "insert into users values(?,?,?,?,?,?,?,?);";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, email);
			ps.setString(6, school);
			ps.setString(7, year);
			ps.setInt(8, type);
			int status = ps.executeUpdate();
			if(status==1) {
				return "User succeed added!";
			}
			else {
				return "Fail to add user!";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Error Occurred!";
	}

	@Override
	public List<User> getAllTeachers() {
		String sql = "select * from Users where user_type=2;";
		DbManager db = new DbManager();
		Connection conn = null;
		List<User> list = new ArrayList<>();
		try {
			conn = db.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString(1));
				user.setF_name(rs.getString(3));
				user.setL_name(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setSchool(rs.getString(6));
				user.setYear(rs.getString(7));
				user.setUser_type(rs.getInt(8));
				list.add(user);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//System.out.println(list.size());
		return list;
	}

}
