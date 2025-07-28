package homework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseCityScreen extends homework.screens.Screen {
    @AndroidFindBy(accessibility = "Кнопка назад в меню")
    MobileElement backButton;

    public ChooseCityScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void back() {
        backButton.click();
    }
}
