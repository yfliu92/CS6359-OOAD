package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.StudentDao;
import daoImp.StudentDaoImpl;

/**
*  @author Jie Zheng
*  @version create date: Oct 24, 2018
*
*/
public class StudentTest {
	
	StudentDao sdao = new StudentDaoImpl();
	@Test
	public void registerTest() {
		// this student has already register this course
		String res = sdao.register("6","1111122222");
		assertEquals(res,"You have alredy registered this course!");
		
		// Error Occurred
		res = sdao.register("", "1111122222");
		assertEquals(res,"Error Occurred!");
		
		// succeed
		res = sdao.register("7", "1111122222");
		assertEquals(res,"Successfully Registered the Course!");
	}
	
	@Test
	public void dropTest() {
		// student does not register this course
		String res = sdao.drop("8", "1111122222");
		assertEquals(res,"Error Occurred!");
		
		// course id does not exist
		res = sdao.drop("100","1111122222");
		assertEquals(res,"Error Occurred!");
		
		// user id does not exist
		res = sdao.drop("8", "1111122222");
		assertEquals(res,"Error Occurred!");
		
		// succeed
		res = sdao.drop("7", "1111122222");
		assertEquals(res,"Successfully drop the Course!");
	}
}
