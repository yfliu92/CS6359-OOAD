package unitTest;

import dao.SyllabusDao;
import daoImp.SyllabusDaoImpl;
import domain.Syllabus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SyllabusTest {
    SyllabusDao syllabusDao=new SyllabusDaoImpl();
//    @Test
//    public void getDetailTest(){
//        Syllabus syllabus=syllabusDao.getDetail("1");
//        assertEquals(syllabus.getDescription(),"asd");
//        assertEquals(syllabus.getGrading(),"asd");
//        assertEquals(syllabus.getTaName(),"qwe");
//        assertEquals(syllabus.getTaEmail(),"asd");
//    }
    @Test
    public void update(){
        Syllabus syllabus=new Syllabus();
        syllabus.setTaEmail("948@gmail.com");
        syllabus.setTaName("cws");
        syllabus.setGrading("A:99");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setSyllabusId("2");
        //update syllabus
        int result=syllabusDao.update(syllabus);
        assertEquals(result,1);

        //Don't have this syllabus
        syllabus.setSyllabusId("3");
        result=syllabusDao.update(syllabus);
        assertEquals(result,0);
    }
}
