import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HealthIOSTest {
    private AppiumDriver<MobileElement> driver;
    
    // Первые 5 элементов с аннотациями
    @iOSFindBy(accessibility = "Summary")
    private MobileElement summaryTitle;
    
    @iOSFindBy(accessibility = "summaryIcon")
    private MobileElement summaryIcon;
    
    @iOSFindBy(accessibility = "Favorites")
    private MobileElement favoritesTitle;
    
    @iOSFindBy(accessibility = "Edit")
    private MobileElement editBtn;
    
    @iOSFindBy(accessibility = "Steps")
    private MobileElement stepsBtn;
    
    public void setUp() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("deviceName", "iPhone 12");
        caps.setCapability("platformVersion", "14.5");
        caps.setCapability("bundleId", "com.apple.Health");
        caps.setCapability("automationName", "XCUITest");
        
        driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    
    public void testHealthApp() throws InterruptedException {
        // Ожидание загрузки экрана
        Thread.sleep(2000);
        
        // Проверка первых 5 элементов
        verifyElementDisplayed(summaryTitle);
        verifyElementDisplayed(summaryIcon);
        verifyElementDisplayed(favoritesTitle);
        verifyElementDisplayed(editBtn);
        verifyElementDisplayed(stepsBtn);
        
        // Остальные элементы через методы драйвера
        MobileElement noDataText = driver.findElementByAccessibilityId("No Data");
        MobileElement showAllBtn = driver.findElementByAccessibilityId("Show All Health Data");
        MobileElement getMoreTitle = driver.findElementByAccessibilityId("Get More From Health");
        MobileElement starIcon = driver.findElementByAccessibilityId("starIcon");
        MobileElement getStartedBtn = driver.findElementByAccessibilityId("Get Started");
        
        // Проверка остальных элементов
        verifyElementDisplayed(noDataText);
        verifyElementDisplayed(showAllBtn);
        verifyElementDisplayed(getMoreTitle);
        verifyElementDisplayed(starIcon);
        verifyElementDisplayed(getStartedBtn);
    }
    
    private void verifyElementDisplayed(MobileElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        assert element.isDisplayed();
    }
    
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
