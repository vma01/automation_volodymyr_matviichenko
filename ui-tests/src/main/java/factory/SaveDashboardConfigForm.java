package factory;

import webElements.SaveDashboardConfigWebElements;

import static com.codeborne.selenide.Condition.text;

public class SaveDashboardConfigForm implements SaveDashboardConfigWebElements {

    public SaveDashboardConfigForm setCustomer(String customerValue) {
        customerInput().setValue(customerValue);
        return new SaveDashboardConfigForm();
    }

    public SaveDashboardConfigForm setExecution(String executionValue) {
        executionInput().setValue(executionValue);
        return new SaveDashboardConfigForm();
    }

    public SaveDashboardConfigForm setDashboardConfigFile(String dashboardConfigFilePath) {
        dashboardConfigFileInput().setValue(dashboardConfigFilePath);
        return new SaveDashboardConfigForm();
    }

    public SaveDashboardConfigForm clickOnSaveBtn() {
        saveBtn().click();
        return new SaveDashboardConfigForm();
    }
    public void assertSuccessMessage(String message) {
        alertSuccess().shouldHave(text(message));
    }
}
