package unitTest;

import dao.CommentDao;
import daoImp.CommentDaoImpl;
import domain.Comment;
import domain.Course;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class CommentDaoImplTest {
    CommentDao cd = new CommentDaoImpl();

    /**
     * Test when the user exists and ever made comments
     */
    @Test
    public void getAll() {
        List<Comment> all = cd.getAll("123");
        assertTrue("Should be larger than 0", all.size() > 0);
    }

    /**
     * Test when the user doesn't exist
     */
    @Test
    public void getAll2() {
        List<Comment> all = cd.getAll("unit_test");
        assertTrue("Should be equal 0", all.size() == 0);
    }

    /**
     * Test when the course exists and has comments
     */
    @Test
    public void getCommentsByCourse() {
        List<Comment> commentsByCourse = cd.getCommentsByCourse("2");
        assertThat(commentsByCourse, not(commentsByCourse.isEmpty()));
    }

    /**
     * Test when the course doesn't exist
     */
    @Test
    public void getCommentsByCourse2() {
        List<Comment> commentsByCourse = cd.getCommentsByCourse("not_exist_course_id");
        assertEquals("Should be 0", 0, commentsByCourse.size());
    }

    /**
     * Test createComment with the correct userId nad course
     */
    @Test
    public void createComment() {
        Comment comment = new Comment();
        Course course = new Course();
        course.setCid(1);
        comment.setRating(5);
        comment.setContent("Unit Test");
        comment.setUserId("123");
        comment.setCourse(course);

        int status = cd.createComment(comment);
        assertEquals("Should return 1", 1, status);
    }

    /**
     * Test createComment with error userId
     */
    @Test
    public void createComment2() {
        Comment comment = new Comment();
        Course course = new Course();
        course.setCid(1);
        comment.setRating(5);
        comment.setContent("Unit Test");
        comment.setUserId("Test");
        comment.setCourse(course);

        int status = cd.createComment(comment);
        assertEquals("Should return 0", 0, status);
    }
}