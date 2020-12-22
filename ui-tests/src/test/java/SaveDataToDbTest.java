import factory.GeneralConfigurationForm;
import factory.SaveDashboardConfigForm;
import org.testng.annotations.Test;

public class SaveDataToDbTest extends BaseUITest {
    public static final String ALERT_SUCCESS_MESSAGE = "Data successfully saved in DB from a.json file";
    public static final String CUSTOMER_VALUE = "interview_test";
    public static final String EXECUTION_VALUE = "interview_test_execution";
    public static final String DASHBOARD_CONFIG_FILE_PATH = "C:/Users/a.json";

    @Test
    public void testSaveDataToDb() {
        GeneralConfigurationForm.open()
                .clickOnFileBtn()
                .selectSaveOption()
                .setCustomer(CUSTOMER_VALUE)
                .setExecution(EXECUTION_VALUE)
                .setDashboardConfigFile(DASHBOARD_CONFIG_FILE_PATH)
                .clickOnSaveBtn();

        at(SaveDashboardConfigForm.class).assertSuccessMessage(ALERT_SUCCESS_MESSAGE);
    }
}
