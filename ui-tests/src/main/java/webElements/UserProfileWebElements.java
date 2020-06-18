package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface UserProfileWebElements {
    default SelenideElement saveBtn() {
        return $(By.id("#submit"));
    }
    default SelenideElement profileImage() {return $(By.id("#file-upload"));}
}
