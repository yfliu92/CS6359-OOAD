package dao;

import domain.User;

/**
* @author zxy
* @version Oct 19, 2018 2:13:44 PM
* 
*/
public interface AttendanceDao {
	public User attend(String key, String id);
}
