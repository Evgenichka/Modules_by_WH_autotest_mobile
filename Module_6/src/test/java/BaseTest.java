import homework.DriverFactory;
import homework.Platform;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

public class BaseTest {
    private final DriverFactory driverFactory = new DriverFactory();
    AppiumDriver<?> driver;

    @Before
    public void setDriver() throws MalformedURLException {
        driver = driverFactory.setUp(Platform.ANDROID);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
