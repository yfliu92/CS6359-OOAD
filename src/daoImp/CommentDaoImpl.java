package daoImp;

import dao.CommentDao;
import db.DbManager;
import domain.Comment;
import domain.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    static Connection conn;
    static PreparedStatement ps;
    DbManager db = new DbManager();

    @Override
    public List<Comment> getAll(String userId) {
        List<Comment> results = new ArrayList<>();
        String sql = "SELECT C.*, course.* FROM COMMENTS C, COURSES course, ( select stu.course_id from STU_COURSES stu where stu.stu_id = ?) RES WHERE RES.course_id=c.course_id and RES.course_id=course.id";
        String sql2 = "SELECT C.*, course.* FROM COMMENTS C, COURSES course WHERE course.teacher_id=? and c.course_id=course.id";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Comment c = new Comment();
                c.setId(resultSet.getString(1));
                c.setRating(resultSet.getInt(2));
                c.setContent(resultSet.getString(3));
                c.setUserId(resultSet.getString(5));

                Course course = new Course();
                course.setCid(resultSet.getInt(6));
                course.setCname(resultSet.getString(7));
                course.setPrefix(resultSet.getString(8));
                course.setCno(resultSet.getString(9));
                course.setSno(resultSet.getString(10));
                course.setRoom(resultSet.getString(11));
                course.setCapacity(resultSet.getInt(12));
                course.setYear(resultSet.getString(13));
                course.setSemester(resultSet.getString(14));
                course.setSday(resultSet.getString(15));
                course.setEday(resultSet.getString(16));
                course.setDays(resultSet.getString(17));
                course.setStime(resultSet.getString(18));
                course.setEtime(resultSet.getString(19));
                course.setTeacher_id(resultSet.getString(20));
                course.setSyllabus_no(resultSet.getString(21));

                c.setCourse(course);

                results.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql2);
            ps.setString(1, userId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Comment c = new Comment();
                c.setId(resultSet.getString(1));
                c.setRating(resultSet.getInt(2));
                c.setContent(resultSet.getString(3));
                c.setUserId(resultSet.getString(5));

                Course course = new Course();
                course.setCid(resultSet.getInt(6));
                course.setCname(resultSet.getString(7));
                course.setPrefix(resultSet.getString(8));
                course.setCno(resultSet.getString(9));
                course.setSno(resultSet.getString(10));
                course.setRoom(resultSet.getString(11));
                course.setCapacity(resultSet.getInt(12));
                course.setYear(resultSet.getString(13));
                course.setSemester(resultSet.getString(14));
                course.setSday(resultSet.getString(15));
                course.setEday(resultSet.getString(16));
                course.setDays(resultSet.getString(17));
                course.setStime(resultSet.getString(18));
                course.setEtime(resultSet.getString(19));
                course.setTeacher_id(resultSet.getString(20));
                course.setSyllabus_no(resultSet.getString(21));

                c.setCourse(course);

                results.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    @Override
    public List<Comment> getCommentsByCourse(String courseId) {
        List<Comment> results = new ArrayList<>();
        DbManager db = new DbManager();
        Connection conn;
        PreparedStatement ps;
        String sql = "SELECT C.*, course.* FROM COMMENTS C, COURSES course WHERE c.course_id=course.id and course.id=?";

        try {
            conn = db.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, courseId);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Comment c = new Comment();
                Course course = new Course();

                c.setId(resultSet.getString(1));
                c.setRating(resultSet.getInt(2));
                c.setContent(resultSet.getString(3));
                c.setUserId(resultSet.getString(5));

                // set all the attributes belongs to the course
                course.setCid(resultSet.getInt(6));
                course.setCname(resultSet.getString(7));
                course.setPrefix(resultSet.getString(8));
                course.setCno(resultSet.getString(9));
                course.setSno(resultSet.getString(10));
                course.setRoom(resultSet.getString(11));
                course.setCapacity(resultSet.getInt(12));
                course.setYear(resultSet.getString(13));
                course.setSemester(resultSet.getString(14));
                course.setSday(resultSet.getString(15));
                course.setEday(resultSet.getString(16));
                course.setDays(resultSet.getString(17));
                course.setStime(resultSet.getString(18));
                course.setEtime(resultSet.getString(19));
                course.setTeacher_id(resultSet.getString(20));
                course.setSyllabus_no(resultSet.getString(21));

                c.setCourse(course);

                results.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public int createComment(Comment comment) {
        int status = 0;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("insert into COMMENTS(rating, content, course_id, user_id) values(?,?,?,?);");
            ps.setString(1, String.valueOf(comment.getRating()));
            ps.setString(2, comment.getContent());
            ps.setString(3, String.valueOf(comment.getCourse().getCid()));
            ps.setString(4, comment.getUserId());
            status = ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}
