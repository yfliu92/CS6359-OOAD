package unitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import dao.CourseDao;
import daoImp.CourseDaoImpl;

/**
*  @author Jie Zheng
*  @version create date: Oct 24, 2018
*
*/
public class CourseTest {
	CourseDao cdao = new CourseDaoImpl();
	@Test
	public void getSumTest() {
		//students register this course
		int num = cdao.getStuNum("6");
		assertEquals(num, 1);
		
		//no student register this course
		num = cdao.getStuNum("10");
		assertEquals(num, 0);
	}

}
