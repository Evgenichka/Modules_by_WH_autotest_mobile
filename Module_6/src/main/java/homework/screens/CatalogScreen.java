package homework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CatalogScreen extends homework.screens.Tabbar {
    @AndroidFindBy(uiAutomator = "text(\"Смартфоны и гаджеты\")")
    MobileElement smartphonesAndGadgetsList;
    @AndroidFindBy(uiAutomator = "text(\"Samsung\")")
    MobileElement samsungTitle;

    public CatalogScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void openSmartphonesAndGadgets() {
        smartphonesAndGadgetsList.click();
    }

    public MobileElement getSamsungTitle() {
        return samsungTitle;
    }
}
