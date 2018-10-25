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
	public int setRK(String id, String rk);

	public int endAttendance(String id);

	public List<User> showAbsence();
}
