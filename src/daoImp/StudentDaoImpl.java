package daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import db.DbManager;
import domain.Course;
import domain.User;

/**
*  @author Jie Zheng
*  @version create date: Oct 17, 2018
*
*/
public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean enroll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean drop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getStuInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> getStuCourse(String id) {
		String sql = "select c.*, u.f_name,u.l_name from courses c left join Users u on c.teacher_id = u.id where c.id in (select course_id from stu_courses where stu_id = '"+id+"');";
		//System.out.println(sql);
		List<Course> list = new ArrayList<>();
		DbManager db = new DbManager();
		Connection conn = null;
		try {
			conn = db.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery(sql);
			while(rs.next()){
				Course c = new Course();
				c.setCid(rs.getInt(1));
				c.setCname(rs.getString(2));
				c.setPrefix(rs.getString(3));
				c.setCno(rs.getString(4));
				c.setSno(rs.getString(5));
				c.setRoom(rs.getString(6));
				c.setCapacity(rs.getInt(7));
				c.setYear(rs.getString(8));
				c.setSemester(rs.getString(9));
				c.setSday(rs.getString(10));
				c.setEday(rs.getString(11));
				c.setDays(rs.getString(12));
				c.setStime(rs.getString(13));
				c.setEtime(rs.getString(14));
				c.setTeacher_id(rs.getString(15));
				c.setSyllabus_no(rs.getString(16));
				c.setTeacher_name(rs.getString(17)+" "+rs.getString(18));
				list.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Course> searchCourse(String cname, String cno, String sno, String prefix, String year, String semester,
			String tid) {
		List<Course> list = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("select c.*, u.f_name,u.l_name from courses c left join Users u on c.teacher_id = u.id ");
		if(!(cname.equals("")&&cno.equals("")&&sno.equals("")&&prefix==null&&year.equals("")&&semester.equals("")&&tid==null)) {
			sb.append("where ");
		}
		if(!cname.equals("")) {
			sb.append("c.course_name like '"+cname+"' and ");
		}
		if(!cno.equals("")) {
			sb.append("c.course_no='"+cno+"' and ");
		}
		if(!sno.equals("")) {
			sb.append("c.section_no='"+sno+"' and ");
		}
		if(!prefix.equals("0")) {
			sb.append("c.prefix='"+prefix+"' and ");
		}
		if(!year.equals("")) {
			sb.append("c.year='"+year+"' and ");
		}
		if(!semester.equals("")) {
			sb.append("c.semester='"+semester+"' and ");
		}
		if(!tid.equals("-1")) {
			sb.append("c.teacher_id='"+tid+"'");
		}
		System.out.println(sb.toString());
		return null;
	}

}
