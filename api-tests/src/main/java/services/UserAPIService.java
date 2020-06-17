package services;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.User;

public class UserAPIService extends APIService {

    public Response getGetUserAuthToken(User user, String encodeHashValue) {
        String userCredential = String.format("{\"login\": \"%s\", \"password\": \"%s\"}", user.getLogin(), user.getPassword());

        return setUp().contentType(ContentType.JSON)
                .header("Authorization", "Basic " + encodeHashValue)
                .body(userCredential)
                .post("/token");
    }

    public Response getUserProfile(String userProfileToken) {
        return setUp().contentType(ContentType.JSON)
                .header("Authorization", userProfileToken)
                .get("/profile");
    }

}
