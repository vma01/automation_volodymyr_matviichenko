package factory;

import io.qameta.allure.Step;
import webElements.UserProfileWebElements;

import java.io.File;

public class UserProfileModalForm implements UserProfileWebElements {

    @Step
    public UserProfileModalForm uploadUserImage(String imagePath) {
        profileImage().uploadFile(new File(imagePath));
        return new UserProfileModalForm();
    }

    @Step
    public MainPage clickOnSaveBtn() {
        saveBtn().click();
        return new MainPage();
    }
}
