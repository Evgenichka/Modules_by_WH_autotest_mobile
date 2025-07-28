import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class ModuleHW {
    private final DriverFactory driverFactory = new DriverFactory();
    private AndroidDriver<?> driver;
    @AndroidFindBy(id = "btnJoinConf")
    MobileElement btnJoinConf;

    @AndroidFindBy(id = "txtTitle")
    MobileElement txtTitle;

    @AndroidFindBy(id = "btnBack")
    MobileElement btnBack;

    @AndroidFindBy(id = "panelConfNumber")
    MobileElement panelConfNumber;

    @AndroidFindBy(id = "btnGotoVanityUrl")
    MobileElement btnGotoVanityUrl;

    @AndroidFindBy(id = "panelScreenName")
    MobileElement panelScreenName;

    @Before
    public void setDriver() throws MalformedURLException {

        driver = driverFactory.setUp();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Test
    public void homeTest() throws InterruptedException {

        Thread.sleep(2000);

        btnJoinConf.click();

        txtTitle.isDisplayed();
        btnBack.isDisplayed();
        panelConfNumber.isDisplayed();
        btnGotoVanityUrl.isDisplayed();
        panelScreenName.isDisplayed();


        MobileElement joinButton = (MobileElement) driver.findElementById("btnJoin");
        MobileElement linkText = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"tap on the link to join the meeting\")");
        MobileElement optionsTitle = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"JOIN OPTIONS\")");
        MobileElement optionNoAudio = (MobileElement) driver.findElementByAndroidUIAutomator("textContains(\"Don't Connect To Audio\")");
        MobileElement chkNoAudio = (MobileElement) driver.findElementById("chkNoAudio");

        joinButton.isDisplayed();
        linkText.isDisplayed();
        optionsTitle.isDisplayed();
        optionNoAudio.isDisplayed();
        chkNoAudio.isDisplayed();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
