package unitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import dao.AttendanceTeacherDao;
import daoImp.AttendanceTeacherDaoImpl;


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
	
}
