package unitTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import dao.AttendanceTeacherDao;
import daoImp.AttendanceTeacherDaoImpl;
import domain.Course;


/**
* @author zxy
* @version Oct 28, 2018 1:39:13 PM
* 
*/
public class AttendanceTeacherTest {
	AttendanceTeacherDao atDao = new AttendanceTeacherDaoImpl();
	@Test
	public void startAttendance() {
		int res = atDao.setRK("12345", "7062", 6359);
		assertEquals(res,1);	
	}
	
	@Test
	public void endAttendance() {
		int res = atDao.endAttendance("12345", 6359);
		assertEquals(res,1);	
	}
	@Test
	public void getAllCourse() {
		List<Course> list = atDao.getAllCourse("12345");
		assertEquals(list.size(), 2);
		Course course1=list.get(0);
		Course course2=list.get(1);
		assertEquals(course1.getCname(), "4567");
		assertEquals(course2.getCname(), "1234");
	}
	
}
