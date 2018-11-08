package domain;

public class Comment {
    private String id;
    private int rating;
    private String content;
    private String courseId;
    private String userId;

    public Comment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String commentId) {
        this.id = commentId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
