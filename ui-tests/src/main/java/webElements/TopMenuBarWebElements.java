package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface TopMenuBarWebElements {
    default SelenideElement fileBtn() {
        return $(By.id("#file"));
    }
    default SelenideElement selectSave() {
        return $(By.cssSelector("#file li:first-child"));
    }
}
