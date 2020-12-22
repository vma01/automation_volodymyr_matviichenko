package factory;

import webElements.TopMenuBarWebElements;

public class TopMenuBar implements TopMenuBarWebElements {

    public TopMenuBar clickOnFileBtn() {
        fileBtn().click();
        return new TopMenuBar();
    }

    public SaveDashboardConfigForm selectSaveOption() {
        selectSave().getSelectedOption();
        return new SaveDashboardConfigForm();
    }
}
