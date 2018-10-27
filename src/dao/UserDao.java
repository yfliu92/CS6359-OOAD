package dao;

import backcenter.Login;
import domain.User;

/**
* @author zxy
* @version Sep 30, 2018 5:04:42 PM
* 
*/
public interface UserDao {
	public int register(User user);
	
	/*
	 * Retrieve the Customer object from the database
	 */
	public User validateUser(Login login);
	public User getProfile(String id);
}
