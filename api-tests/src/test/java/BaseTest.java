import io.restassured.RestAssured;
import model.User;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.BeforeClass;
import services.UserAPIService;
import utils.ProjectConfig;

public class BaseTest {
    UserAPIService userAPI = new UserAPIService();

    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = ConfigFactory.create(ProjectConfig.class).apiPath();
    }
}
