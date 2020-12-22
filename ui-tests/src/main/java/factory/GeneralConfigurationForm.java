package factory;

import com.codeborne.selenide.Selenide;
import webElements.GeneralConfigWebElements;

public class GeneralConfigurationForm implements GeneralConfigWebElements {

    public static TopMenuBar open() {
        Selenide.open("/");
        return new TopMenuBar();
    }
}
