package dao;

import domain.Syllabus;

public interface SyllabusDao {
    public Syllabus getDetail(String syllabus_id);
    public int update(Syllabus syllabus);
}
