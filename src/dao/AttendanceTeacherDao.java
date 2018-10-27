package dao;

import java.util.List;

import domain.Course;
import domain.User;

/**
* @author zxy
* @version Oct 19, 2018 2:13:44 PM
* 
*/
public interface AttendanceTeacherDao {
	public int setRK(String id, String rk,int cid);

	public int endAttendance(String id, int cid);

	public List<User> showAbsence(int cid);

	public List<Course> getAllCourse(String id);
}
