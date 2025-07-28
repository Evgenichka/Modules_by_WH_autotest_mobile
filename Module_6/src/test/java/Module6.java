import homework.GoToMainFromCartButton;
import homework.screens.CartScreen;
import homework.screens.CatalogScreen;
import homework.screens.ChooseCityScreen;
import homework.screens.ListsScreen;
import homework.screens.MainScreen;
import homework.screens.ProfileScreen;
import homework.screens.Tabbar;
import org.junit.Assert;
import org.junit.Test;
//import static junit.framework.TestCase.assertEquals;

public class Module6 extends BaseTest {

    @Test
    public void homeTest() {

        MainScreen mainScreen = new MainScreen(driver);
        // проверка отображения логотипа "Мвидео" на Главном экране
        mainScreen.getLogotypeIcon().isDisplayed();
        // переход на экран Списки
        Tabbar tabbar = new Tabbar(driver);
        tabbar.goToList();
        // нажатие на кнопку "Посмотреть каталог"
        ListsScreen listsScreen = new ListsScreen(driver);
        listsScreen.showCatalog();
        // раскрытие списка "Смартфоны и гаджеты"
        CatalogScreen catalogScreen = new CatalogScreen(driver);
        catalogScreen.openSmartphonesAndGadgets();
        // проверка отображения элемента "Samsung"
        catalogScreen.getSamsungTitle().isDisplayed();
        // переход на экран Профиль
        tabbar.goToProfile();
        // переход на выбор города
        ProfileScreen profileScreen = new ProfileScreen(driver);
        profileScreen.chooseCity();
        // закрытие экрана выбора города
        ChooseCityScreen chooseCityScreen = new ChooseCityScreen(driver);
        chooseCityScreen.back();
        // переход на экран Корзина
        tabbar.goToCart();
        // переход на кнопку "На Главную"
        CartScreen cartScreen = new CartScreen(driver);
        cartScreen.goToMainScreenStrategy(new GoToMainFromCartButton(driver));
        // проверка что заголовок на экране солержит текст "Я в магазине"
        Assert.assertEquals("Я в магазине", mainScreen.getStoreMainTitleText());
    }
}

