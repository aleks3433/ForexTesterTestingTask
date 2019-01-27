import framework.BrowserManager;
import framework.Navigation;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.OrderPage;

import static org.testng.Assert.assertTrue;

public class RegressionTest {

    @BeforeTest
    public void openBrowser() {
        BrowserManager.openBrowser();
    }

    @Test
    public void testForexTesterPrices() {
        OrderPage orderPage = Navigation.openOrderPage();
        assertTrue(orderPage.isProductPricesCorrect(1), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesTwoLicenses() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .selectTwoLicenses();
        assertTrue(orderPage.isProductPricesCorrect(2), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesStandardMonthlySubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .chooseStandardMonthlySubscription();
        assertTrue(orderPage.isProductPricesCorrect(3), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesStandardAnnualSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .chooseStandardAnnualSubscription();
        assertTrue(orderPage.isProductPricesCorrect(4), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesStandardLifeSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .chooseStandardLifetimeSubscription();
        assertTrue(orderPage.isProductPricesCorrect(5), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesVIPMonthlySubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .chooseVIPMonthlySubscription();
        assertTrue(orderPage.isProductPricesCorrect(6), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesVIPAnnualSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .clickGotItButton()
                .moveToPricesTable()
                .chooseVIPAnnualSubscription();
        assertTrue(orderPage.isProductPricesCorrect(7), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPricesVIPLifeSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .clickGotItButton()
                .moveToPricesTable()
                .chooseVIPLifetimeSubscription();
        assertTrue(orderPage.isProductPricesCorrect(8), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesStandardMonthlySubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseStandardMonthlySubscription();
        assertTrue(orderPage.isProductPricesCorrect(9), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesStandardAnnualSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseStandardAnnualSubscription();
        assertTrue(orderPage.isProductPricesCorrect(10), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesStandardLifeSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseStandardLifetimeSubscription();
        assertTrue(orderPage.isProductPricesCorrect(11), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesVIPMonthlySubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseVIPMonthlySubscription();
        assertTrue(orderPage.isProductPricesCorrect(12), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesVIPAnnualSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .clickGotItButton()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseVIPAnnualSubscription();
        assertTrue(orderPage.isProductPricesCorrect(13), "All comperisons should be true");
    }

    @Test
    public void testTwoLicensesForexTesterPricesVIPLifeSubscription() {
        OrderPage orderPage = Navigation.openOrderPage()
                .clickGotItButton()
                .moveToPricesTable()
                .selectTwoLicenses()
                .chooseVIPLifetimeSubscription();
        assertTrue(orderPage.isProductPricesCorrect(14), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPlusCopierPrices() {
        OrderPage orderPage = Navigation.openOrderPage();
        assertTrue(orderPage.isForexTesterPlusCopierPricesCorrect(), "All comperisons should be true");
    }

    @Test
    public void testForexTesterPlusSmartToolsPrices() {
        OrderPage orderPage = Navigation.openOrderPage();
        assertTrue(orderPage.isForexTesterPlusSmartToolsPricesCorrect(), "All comperisons should be true");
    }

    @AfterTest
    public void closeBrowser() {
        BrowserManager.closeBrowser();
    }
}
