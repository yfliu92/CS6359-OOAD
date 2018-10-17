package dao;

import java.util.List;

import domain.Course;
import domain.User;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public interface AdminDao {
	public String addUser(String id,String pwd,String fname,String lname,String email,String school,String year,int type);
	public List<User> getAllUsers();
	public List<User> getAllTeachers();
	public String addCourse(String cname, String prefix,String cno,String sno, String room,int capacity,String year,
			String semester, String sday, String eday,String days, String stime, String etime,String teacherid,int cid);
	public String delCourse(int courseid);
	public boolean updateCourse(int courseid);
	public int insertSyllabus();
}
