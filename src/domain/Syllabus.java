package domain;

public class Syllabus {
    private String syllabusId;
    private String description;
    private String grading;
    private String taName;
    private String taEmail;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }

    public String getTaEmail() {
        return taEmail;
    }

    public void setTaEmail(String taEmail) {
        this.taEmail = taEmail;
    }

    public String getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(String syllabusId) {
        this.syllabusId = syllabusId;
    }
}
