package unitTest;

import static org.junit.Assert.*;

import domain.Course;
import org.junit.Test;

import dao.CourseDao;
import daoImp.CourseDaoImpl;

import java.util.List;

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
	@Test
	public void getCourseListTest(){
		//teacher get course
		List<Course> list = cdao.getCourseList("cws");
		assertEquals(list.size(), 2);
		Course course1=list.get(0);
		Course course2=list.get(1);
		assertEquals(course1.getCname(), "software testing");
		assertEquals(course2.getCname(), "software");
	}
}
