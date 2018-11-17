package domain;

public class Comment {
    private String id;
    private int rating;
    private String content;
    private String userId;

    private Course course;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
