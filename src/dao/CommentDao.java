package dao;

import domain.Comment;

import java.util.List;

public interface CommentDao {
    public List<Comment> getAll(String userId);

    public List<Comment> getCommentsByCourse(String courseId);
}
