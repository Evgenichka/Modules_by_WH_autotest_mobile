package homework.screens;

import homework.GoToMainScreenStrategy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartScreen extends homework.screens.Tabbar {
    @AndroidFindBy(id = "cart_empty_check_this_out_button")
    MobileElement goToMainButton;

    public CartScreen(AppiumDriver<?> driver) {
        super(driver);
    }

    public void goToMain() {
        goToMainButton.click();
    }

    public void goToMainScreenStrategy(GoToMainScreenStrategy goToMainScreenStrategy) {
        goToMainScreenStrategy.goToMain();
    }
}
