package com.automation.core.suite.center.tests;

import com.automation.core.suite.AutomationCoreTest;
import com.automation.core.suite.annotations.Description;
import com.automation.core.suite.annotations.Title;
import com.automation.core.suite.models.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.sleep;

/**
 * The type Testing General.
 */
@Title("Module=TestingGeneral :")
@Description("TestingGeneral")
public class TestingGeneral extends AutomationCoreTest {

    /**
     * Instantiates a new Testing General.
     *
     * @param browser the browser
     */
    @Factory(dataProvider = "browsers")
    public TestingGeneral(Browser browser) {
        super(browser);
    }

    /**
     * Sets up.
     */
    @BeforeMethod(alwaysRun = true)
    private void setUp() {
    }

    /**
     * Testing general methods.
     */
    @Test(groups = {"TestingGeneral"})
    @Title(": TestingGeneral")
    public void testingGeneralMethods() {
        try {
            getWebDriver().manage().window().maximize();
            getWebDriver().get("https://www.google.com");

            sleep(3000);

            Assert.assertEquals(getWebDriver().getTitle(), "Google");

            getWebDriver().quit();
        } catch (Exception e) {
            getLog().info(e.getMessage());
        } finally {
            //errorLogs();
            getWebDriver().quit();
        }
    }
}
