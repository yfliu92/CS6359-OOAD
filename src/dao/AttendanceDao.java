package dao;

import java.util.List;

import domain.Course;
import domain.User;

/**
* @author zxy
* @version Oct 19, 2018 2:13:44 PM
* 
*/
public interface AttendanceDao {
	public int attend(String key, String id,int cid);

	public List<Course> getAllAvaCourse(String id);
}
