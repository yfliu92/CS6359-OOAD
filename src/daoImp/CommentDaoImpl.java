package daoImp;

import dao.CommentDao;
import db.DbManager;
import domain.Comment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDaoImpl implements CommentDao {
    @Override
    public List<Comment> getAll(String userId) {
        List<Comment> results = new ArrayList<>();
        DbManager db = new DbManager();
        Connection conn;
        PreparedStatement ps;
        String sql = "SELECT C.* FROM COMMENTS C, ( select stu.course_id from STU_COURSES stu where stu.stu_id = ?) RES WHERE RES.course_id=c.course_id";

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
                c.setCourseId(Integer.toString(resultSet.getInt(4)));
                c.setUserId(resultSet.getString(5));

                results.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public List<Comment> getCommentsByCourse(String courseId) {
        return null;
    }
}
