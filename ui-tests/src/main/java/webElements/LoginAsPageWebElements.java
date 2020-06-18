package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface LoginAsPageWebElements {

    default SelenideElement usernameInput() {return $(By.id("username-input"));}
    default SelenideElement passwordInput() {
        return $(By.id("password-input"));
    }
    default SelenideElement loginBtn() {return $(By.cssSelector("#login-button .btn-primary"));}
    default SelenideElement alertSuccess() {return $(By.className("alert-success"));}
}
