package daoImp;

import dao.SyllabusDao;
import db.DbManager;
import domain.Syllabus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        int result = 0;
        conn=db.getConnection();
        String regEx ="^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$" ;
        Pattern pattern = Pattern.compile(regEx);
        String description=syllabus.getDescription();
        String taName=syllabus.getTaName();
        String taEmail=syllabus.getTaEmail();
        String grading=syllabus.getGrading();

        if(description.length()==0){
            return 2;

        }
        else if(taName.length()==0){
            return 3;

        }
        else if(taEmail.length()==0){
            return 4;

        }
        else if(grading.length()==0){
            return 5;

        }
        Matcher matcher = pattern.matcher(taEmail);
        if(!matcher.matches()){
            return 4;

        }

            try {
                ps = conn.prepareStatement("update syllabus set ta_name = ?, ta_email=?, description=?,grading=? where id=?");
                ps.setString(1, syllabus.getTaName());
                ps.setString(2, syllabus.getTaEmail());
                ps.setString(3, syllabus.getDescription());
                ps.setString(4, syllabus.getGrading());
                ps.setString(5, syllabus.getSyllabusId());
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return result;
    }
}
