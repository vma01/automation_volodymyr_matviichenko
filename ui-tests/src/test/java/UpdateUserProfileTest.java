import factory.LoginModalForm;
import factory.MainPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateUserProfileTest extends BaseUITest {
    private final String ALERT_SUCCESS_MESSAGE = "Login successful";
    private final String LOGGED_USER_MESSAGE = "Logged in as %s %s";
    private final String LOGOUT_MESSAGE = "Login";

    @DataProvider(name = "users")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"John", "Willington", "admin@test.com", "qwerty1", "resources/user1.jpg"},
                {"Peter", "Stones", "j.accountant@test.com", "qwerty2", "resources/user2.jpg"},
                {"Mark", "Ditriht", "accountant@test.com", "qwerty3", "resources/user3.jpg"},
                {"Maxime", "Trudeau", "s.accountant@test.com", "qwerty4", "resources/user4.jpg"},
                {"Derek", "Wolfer", "manager@test.com", "qwerty5", "resources/user5.jpg"},
        };
    }

    @Test(dataProvider = "users")
    public void testUpdateUserProfile(String firstName, String lastName, String login, String password, String imagePath) {

        MainPage mainPage = MainPage.open()
                .clickOnLogin()
                .loginAs(login, password);

        at(LoginModalForm.class).assertSuccessMessage(ALERT_SUCCESS_MESSAGE);
        at(MainPage.class).assertSuccessLogin(String.format(LOGGED_USER_MESSAGE, firstName, lastName));

        mainPage.clickOnUserProfile()
                .uploadUserImage(imagePath)
                .clickOnSaveBtn();

        at(MainPage.class).assertUserImageVisible(imagePath);

        mainPage.logoutBtn();

        at(LoginModalForm.class).assertSuccessMessage(LOGOUT_MESSAGE);
        at(MainPage.class).assertUserImageNotVisible(imagePath);
    }
}
