package daoImp;

import dao.SyllabusDao;
import db.DbManager;
import domain.Syllabus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SyllabusDaoImpl implements SyllabusDao {
    @Override
    public Syllabus getDetail(String syllabus_id) {
        Syllabus syllabus=new Syllabus();
        Connection conn;
        PreparedStatement ps;
        DbManager db = new DbManager();
        conn=db.getConnection();
        try {
            ps=conn.prepareStatement("select * from syllabus where id=?");
            ps.setString(1,syllabus_id);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                syllabus.setSyllabusId(rs.getString(1));
                syllabus.setTaName(rs.getString(2));
                syllabus.setTaEmail(rs.getString(3));
                syllabus.setDescription(rs.getString(4));
                syllabus.setGrading(rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return syllabus;
    }

    @Override
    public int update(Syllabus syllabus) {
        Connection conn;
        PreparedStatement ps;
        DbManager db = new DbManager();
        conn=db.getConnection();
        int result=0;
        try {
            ps=conn.prepareStatement("update syllabus set ta_name = ?, ta_email=?, description=?,grading=? where id=?");
            ps.setString(1,syllabus.getTaName());
            ps.setString(2,syllabus.getTaEmail());
            ps.setString(3,syllabus.getDescription());
            ps.setString(4,syllabus.getGrading());
            ps.setString(5,syllabus.getSyllabusId());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
