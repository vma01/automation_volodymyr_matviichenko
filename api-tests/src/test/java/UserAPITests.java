import lombok.extern.slf4j.Slf4j;
import model.Role;
import model.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import response.UserProfile;
import response.UserToken;
import utils.HashCodeValue;
import utils.UserPermissions;

import java.util.ArrayList;
import java.util.Arrays;

import static utils.UserPermissions.*;

@Slf4j
public class UserAPITests extends BaseTest {

    @DataProvider(name = "users")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                { "John", "Willington", 24, "admin@test.com", "qwerty1", "Admin", Arrays.asList(READ, CREATE, UPDATE, DELETE, BULK_CREATE)},
                { "Peter", "Stones", 29, "j.accountant@test.com", "qwerty2", "Junior accountant", Arrays.asList(READ)},
                { "Mark", "Ditriht", 42, "accountant@test.com", "qwerty3", "Accountant", Arrays.asList(READ, CREATE)},
                { "Maxime", "Trudeau", 31, "s.accountant@test.com", "qwerty4", "Senior accountant", Arrays.asList(READ, CREATE, UPDATE)},
                { "Derek", "Wolfer", 20, "manager@test.com", "qwerty5", "Manager", Arrays.asList(READ, CREATE, UPDATE, BULK_CREATE)},
        };
    }

    @Test(dataProvider = "users")
    void testUserProfileValidation(String firstName, String lastName, int age, String login, String password,
                                   Role role, ArrayList<UserPermissions> permissions) {

        User user = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .age(age)
                .login(login)
                .password(password)
                .role(role)
                .permission(permissions)
                .build();

        UserToken userTokenInfo = userAPI.getGetUserAuthToken(user, HashCodeValue.getEncodeHashCodeValue())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UserToken.class);

        String decodeUserToken = HashCodeValue.getDecodeHashValueCode(userTokenInfo.getAccessToken());
        user.getPermission().forEach(userPermission -> {
            Assert.assertTrue(decodeUserToken.contains(userPermission.name()),
                    "Invalid user permission: " + userPermission.name() + "for user: " + user.getLogin() );
        });

        UserProfile userProfile = userAPI.getUserProfile(userTokenInfo.getAccessToken() + userTokenInfo.getTokenType())
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(UserProfile.class);

        Assert.assertEquals(userProfile.getFirstName(), user.getFirstName(), "Invalid First Name");
        Assert.assertEquals(userProfile.getLastName(), user.getLastName(), "Invalid Last Name");
        Assert.assertEquals(userProfile.getEmail(), user.getLogin(), "Invalid email address");
        Assert.assertEquals(userProfile.getAge(), user.getAge(), "Invalid age");
        Assert.assertNotNull(userProfile.getProfilePicture(), "Invalid picture path");
        Assert.assertEquals(userProfile.getRole().getUserRole(), user.getRole().getUserRole(), "Invalid user role");
    }
}
