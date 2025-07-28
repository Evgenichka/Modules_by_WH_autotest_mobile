package homework.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ListsScreen extends homework.screens.Tabbar {
    @AndroidFindBy(id = "favorites_empty_button")
    MobileElement showCatalogButton;

    public ListsScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void showCatalog() {
        showCatalogButton.click();
    }
}
