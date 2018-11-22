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
    //There are 5 parameters:syllabusid, taname, taemail, description, grading
    //They have 2 status: 0-> invalid , 1->valid
    //each of the test case, we try the combination of 2 of them
    Syllabus syllabus=new Syllabus();
    //test1 syllabus: 0, taname:0, taemail:0, description:0, grading:0
    @Test
    public void test1(){
        syllabus.setTaEmail("94846647gmail.com");
        syllabus.setTaName("");
        syllabus.setGrading("");
        syllabus.setDescription("");
        syllabus.setSyllabusId("3");

        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test2 syllabus: 0, taname:0, taemail:0, description:0, grading:1
    @Test
    public void test2(){
        syllabus.setGrading("A:99");
        syllabus.setDescription("");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test3 syllabus: 0, taname:0, taemail:0, description:1, grading:0
    @Test
    public void test3(){
        syllabus.setGrading("");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setTaName("");
        syllabus.setTaEmail("94846647gmail.com");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,3);
    }
    //test4 syllabus: 0, taname:0, taemail:1, description:0, grading:0
    @Test
    public void test4(){
        syllabus.setDescription("");
        syllabus.setTaEmail("94846647@gmail.com");

        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test5 syllabus: 0, taname:1, taemail:0, description:0, grading:0
    @Test
    public void test5(){
        syllabus.setTaEmail("");
        syllabus.setDescription("");
        syllabus.setTaName("cws");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test6 syllabus: 0, taname:1, taemail:0, description:0, grading:0
    @Test
    public void test6(){
        syllabus.setTaEmail("");
        syllabus.setTaName("cws");
        syllabus.setDescription("");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test7 syllabus: 0, taname:1, taemail:1, description:1, grading:0
    @Test
    public void test7(){
        syllabus.setTaEmail("94846647@gmail.com");
        syllabus.setTaName("cws");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setGrading("");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,5);
    }
    //test8 syllabus: 1, taname:0, taemail:1, description:1, grading:0
    @Test
    public void test8(){
        syllabus.setTaName("");
        syllabus.setSyllabusId("2");
        syllabus.setDescription("asd");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,3);
    }
    //test9 syllabus: 1, taname:1, taemail:0, description:0, grading:1
    @Test
    public void test9(){
        syllabus.setTaName("cws");
        syllabus.setTaEmail("94846647gmail.com");
        syllabus.setDescription("");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,2);
    }
    //test10 syllabus: 0, taname:0, taemail:1, description:1, grading:1
    @Test
    public void test11(){
        syllabus.setTaName("");
        syllabus.setTaEmail("94846647@gmail.com");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setSyllabusId("3");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,3);
    }
//    //test12 syllabus: 0, taname:0, taemail:1, description:1, grading:1
    @Test
    public void test12(){

        syllabus.setGrading("A:99");
        syllabus.setTaName("");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setTaEmail("94846647@gmail.com");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,3);
    }
    //test13 syllabus: 1, taname:1, taemail:1, description:1, grading:1
    @Test
    public void test13(){
        syllabus.setTaEmail("94846647@gmail.com");
        syllabus.setTaName("cws");
        syllabus.setGrading("A:99");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setSyllabusId("3");
        int result=syllabusDao.update(syllabus);
        assertEquals(result,0);
    }
    //test0 syllabus: 1, taname:1, taemail:0, description:1, grading:1
    @Test
    public void test0(){
        syllabus.setTaEmail("94846647gmail.com");
        syllabus.setTaName("cws");
        syllabus.setGrading("A:99");
        syllabus.setDescription("it is a course with no A grades");
        syllabus.setSyllabusId("3");
        //Don't have this syllabus
        int result=syllabusDao.update(syllabus);
        assertEquals(result,4);
    }
}
