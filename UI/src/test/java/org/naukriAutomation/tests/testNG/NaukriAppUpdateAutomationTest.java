package org.naukriAutomation.tests.testNG;

import org.naukriAutomation.Listener.TestListener;
import org.naukriAutomation.actions.ProfileActions;
import org.naukriAutomation.tests.base.BaseTest;
import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class NaukriAppUpdateAutomationTest extends BaseTest {

    private ProfileActions profileActions;

    @BeforeMethod
    @Override
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        DriverFactory.initDriver(browser);
        profileActions = new ProfileActions(DriverFactory.getDriver());
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {

        return new Object[][]{
                {"veerdhavalshinde@gmail.com", "F$esta@09876"}
        };
    }

    @Test(dataProvider = "loginData")
    public void updateResumeHeadline(String username, String password) {
        profileActions.openApp();
        profileActions.login(username, password);
        profileActions.viewProfile();
        profileActions.editResumeHeadline();
        profileActions.saveProfile();
    }
}
