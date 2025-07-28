package homework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfileScreen extends homework.screens.Tabbar {
    @AndroidFindBy(id = "city_select_action")
    MobileElement selectCitvFiled;

    public ProfileScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void chooseCity() {
        selectCitvFiled.click();
    }
}
