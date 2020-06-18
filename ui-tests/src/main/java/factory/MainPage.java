package factory;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import webElements.MainPageWebElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class MainPage implements MainPageWebElements {

    @Step
    public static MainPage open() {
        Selenide.open("/");
        return new MainPage();
    }

    @Step
    public LoginModalForm clickOnLogin() {
        login().click();
        return new LoginModalForm();
    }

    @Step
    public UserProfileModalForm clickOnUserProfile() {
        profileBtn().click();
        return new UserProfileModalForm();
    }

    public void assertSuccessLogin(String message) {
        this.loginMessage().shouldHave(text(message));
    }

    public void assertUserImageVisible(String pathImage) {
        loadedImage(pathImage).shouldBe((visible));
    }

    public void assertUserImageNotVisible(String pathImage) {
        loadedImage(pathImage).shouldNot((visible));
    }
}
