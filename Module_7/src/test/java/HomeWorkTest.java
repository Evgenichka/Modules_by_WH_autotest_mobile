import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class HomeWorkTest extends BaseTest {

    @AndroidFindBy(accessibility = "www.e-katalog")
    MobileElement mobiles;

    @FindBy(xpath = "//div[@id\"owl-slider\"]//a[text()=\"Мобильные\"]")
    MobileElement title;

    @FindBy(xpath = "//a[text()=\"Apple\"]")
    MobileElement apple;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"по популярности\"]/parent::android.view.View")
    MobileElement byPopularFilter;

    @AndroidFindBy(accessibility = "от дешевых к дорогим")
    MobileElement fromCheapToExpensiveFilter;

    @AndroidFindBy(uiAutomator = "new UiScrollable(scrollable(true)).flingToEnd(3)")
    MobileElement scroll;

    @Test
    void ekatalogWebView() {
        title.isDisplayed();
        changeDriverContextToWebView(driver);        // вызов методов переключения контекстов
        apple.click();
        apple.click();
        changeDriverContextNoNative(driver);         // вызов методов переключения контекстов
        byPopularFilter.click();
        fromCheapToExpensiveFilter.click();
        scroll.isDisplayed();
    }

    // методы переключения контекстов
    void changeDriverContextToWebView(AppiumDriver<?> driver) {
        Set<String> contextHandles = driver.getContextHandles();
        for (String name : contextHandles) {
            if (name.contains("WEBVIEW"))
                driver.context(name);
        }
    }

    void changeDriverContextNoNative(AppiumDriver<?> driver) {
        Set<String> contextHandles = driver.getContextHandles();
        for (String name : contextHandles) {
            if (name.contains("NATIVE_APP"))
                driver.context(name);
        }
    }

}
