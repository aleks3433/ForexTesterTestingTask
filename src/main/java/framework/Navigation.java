package framework;

import org.openqa.selenium.support.PageFactory;
import pages.OrderPage;

public class Navigation {

    public static OrderPage openOrderPage() {
        // open needed page
        BrowserManager.getBrowser().get("https://forextester.com/test72");
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }
}
