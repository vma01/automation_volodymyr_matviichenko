package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface MainPageWebElements {
    default SelenideElement login() {
        return $(By.cssSelector("#login > a"));
    }
    default SelenideElement logoutBtn() {
        return $(By.cssSelector("#logout"));
    }
    default SelenideElement profileBtn() {return $(By.cssSelector("#profile"));}
    default SelenideElement loginMessage() {return $(By.cssSelector("#howdy a:first-child"));}
    default SelenideElement loadedImage(String pathImage) {return $(By.xpath("//img[contains(@src, '" + pathImage + "')]"));}
}
