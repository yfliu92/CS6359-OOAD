package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.AdminDao;
import daoImp.AdminDaoImpl;

/**
*  @author Jie Zheng
*  @version create date: Oct 24, 2018
*
*/
public class AdminTest {
	AdminDao adao = new AdminDaoImpl();
	@Test
	public void addCourseTest() {
		// course name is null
		String res = adao.addCourse(null, "CS", "6363", "001", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "123", 0);
		assertEquals("Error Occurred!", res);
		// teacher id does not exist
		res = adao.addCourse("TestCourse 1", "CS", "6363", "001", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "123", 0);
		assertEquals("Error Occurred!", res);
		
		// course already existed
		res = adao.addCourse("TestCourse 1", "CS", "6313", "201", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "123", 0);
		assertEquals("There exists the same course in LOC!", res);
		

		// succeed
		res = adao.addCourse("TestCourse 1", "cs", "6320", "201", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "t3", 0);
		assertEquals("Course succeed added!", res);
	}
	
	@Test
	public void delCourseTest() {
		// course id does not exist
		String res = adao.delCourse(30);
		assertEquals("Error Occurred!", res);
		
		// student has enrolled in the course, can not be deleted
		res = adao.delCourse(6);
		assertEquals("Students have enrolled in this course and course can not be deleted!",res);
		
		// succeed
		res = adao.delCourse(18);
		assertEquals("Course has been deleted!", res);
	}
	
	@Test
	public void editCourseTest() {

		// course name is null
		String res = adao.addCourse(null, "CS", "6363", "001", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "123", 1);
		assertEquals("Error Occurred!", res);
		
		// teacher id does not exist
		res = adao.addCourse("TestCourse 1", "CS", "6363", "001", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "123", 1);
		assertEquals("Error Occurred!", res);
		
		//course does not exist

		res = adao.addCourse("TestCourse 1", "CS", "6363", "001", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "t3", 1);
		assertEquals("Error Occurred!", res);

		// succeed
		res = adao.addCourse("TestCourse 1", "cs", "6320", "201", "412", 60, "2018", "summer", "2018-05-20", "2018-08-20", "TTh", "08:30:00", "09:45:00", "t3", 11);
		assertEquals("Course succeed edited!", res);
	}
	
	@Test
	public void addUserTest() {
		// user already existed
		String res = adao.addUser("admin", "123", "", "", "", "", "", 1);
		assertEquals("User with id:admin has already existed.",res);
		
		//id is null and cause error
		res = adao.addUser(null, "123", "", "", "", "", "", 1);
		assertEquals("Error Occurred!",res);
		
		//succeed
		res = adao.addUser("9998", "9999", "test", "test", "", "", "", 1);
		assertEquals("User succeed added!", res);
	}
	
}
