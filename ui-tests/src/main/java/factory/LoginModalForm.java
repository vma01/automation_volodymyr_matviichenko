package factory;

import io.qameta.allure.Step;
import webElements.LoginAsPageWebElements;

import static com.codeborne.selenide.Condition.text;

public class LoginModalForm implements LoginAsPageWebElements {

    @Step
    public MainPage loginAs(String login, String password) {
        usernameInput().sendKeys(login);
        passwordInput().sendKeys(password);
        loginBtn().click();
        return new MainPage();
    }

    public void assertSuccessMessage(String message) {
        alertSuccess().shouldHave(text(message));
    }
}
