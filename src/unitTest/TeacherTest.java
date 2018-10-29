package unitTest;

import dao.UserDao;
import daoImp.UserDaoImpl;
import domain.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TeacherTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void getProfileTest(){
        User user=userDao.getProfile("cws");
        assertEquals(user.getId(), "cws");
        assertEquals(user.getPassword(), "cws");
        assertEquals(user.getF_name(), "ws");
        assertEquals(user.getL_name(), "c");
        assertEquals(user.getEmail(), "cws@123.com");
        assertEquals(user.getSchool(), "DLUT");
        assertEquals(user.getYear(), "1995");
        assertEquals(user.getUser_type(), 2);
    }
}
