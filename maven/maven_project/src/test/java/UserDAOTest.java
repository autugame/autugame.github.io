import com.qfedu.dao.UserDAO;
import com.qfedu.dao.UserDAOImpl;
import org.junit.Test;

public class UserDAOTest {
    @Test
    public void addUser(){
        UserDAO userDAO = new UserDAOImpl();
        userDAO.addUser();
    }
}
