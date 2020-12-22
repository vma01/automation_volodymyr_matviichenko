package webElements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public interface SaveDashboardConfigWebElements {
    default SelenideElement customerInput() {return $(By.id("customer"));}
    default SelenideElement executionInput() {return $(By.id("execution"));}
    default SelenideElement dashboardConfigFileInput() {return $(By.cssSelector("#dashboard-config-file"));}
    default SelenideElement saveBtn() {return $(By.cssSelector("#saveBtn"));}
    default SelenideElement alertSuccess() {return $(By.className("alert-success"));}
}
