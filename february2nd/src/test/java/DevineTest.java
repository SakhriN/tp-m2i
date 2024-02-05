import com.example.february2nd.DAO.DevineDAOImpl;
import com.example.february2nd.models.Devine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DevineTest {
    Devine test = new Devine("Quelle est la différence entre 2 oranges?", "Le jus");
    DevineDAOImpl devineDAO = new DevineDAOImpl();

    @Test
    void TestZebre3emeDevinette() {
        test = devineDAO.ReadById(3);
        System.out.println(test.getDevine_text());
        Assertions.assertTrue(test.getAnswer().equals("zebre"));
    }
}
