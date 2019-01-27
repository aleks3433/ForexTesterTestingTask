package pages;

import framework.BrowserManager;
import framework.Utilities;
import framework.XLSParser;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class OrderPage {

    // initializing general webElement for assigning exact elements
    WebElement webElement;

    // definiton all needed elements from page
    @FindBy(id = "total")
    WebElement totalPrice;

    @FindBy(className = "nowPrice")
    WebElement nowPriceTester;

    @FindBy(id = "priceStandardData")
    WebElement nowPriceData;

    @FindBy(id = "totalSave")
    WebElement totalSave;

    @FindBy(className = "fullPrice")
    WebElement fullPriceTester;

    @FindBy(xpath = "//span [@class = 'savePrice']")
    WebElement savePriceTester;

    @FindBy(xpath = "//div [@id = 'info']/ul/li[2]")
    WebElement savePriceData;

    @FindBy(className = "tdstandard")
    WebElement standardRadioButton;

    @FindBy(className = "monthlyStandard-label")
    WebElement monthlyStandardSubscriptionInMonth;

    @FindBy(className = "annualStandard-label")
    WebElement annualStandardSubscriptionInMonth;

    @FindBy(className = "lifeStandard-label")
    WebElement lifeStandardSubscription;

    @FindBy(className = "tdvip")
    WebElement vipRadioButton;

    @FindBy(className = "monthlyVip-label")
    WebElement monthlyVipSubscriptionInMonth;

    @FindBy(className = "annualVip-label")
    WebElement annualVipSubscriptionInMonth;

    @FindBy(className = "lifeVip-label")
    WebElement lifeVipSubscription;

    @FindBy(id = "withoutDiscount")
    WebElement fullPriceWithoutDiscount;

    @FindBy(className = "cc-compliance")
    WebElement gotItButton;

    @FindBy(className = "marB12")
    WebElement priceTable;

    @FindBy(id = "licenseQuantity")
    WebElement numberOfLicensesSelection;

    @FindBy(xpath = "(//div[@class=\"old-price\"])[1]")
    WebElement fullPriceWithoutDiscountTesterPlusCopier;

    @FindBy(xpath = "(//div[@class=\"old-price\"])[2]")
    WebElement fullPriceTesterCopierBlock;

    @FindBy(xpath = "(//div[@class=\"old-price\"])[4]")
    WebElement fullPriceWithoutDiscountTesterPlusSmartTools;

    @FindBy(xpath = "(//div[@class=\"old-price\"])[5]")
    WebElement fullPriceTesterSmartToolsBlock;

    @FindBy(xpath = "(//div[@id=\"ftFcPrice\"])[1]")
    WebElement fullPriceTesterPlusCopier;

    @FindBy(xpath = "(//div[@id=\"testerPartFcPrice\"])[1]")
    WebElement nowPriceTesterCopierBlock;

    @FindBy(xpath = "(//div[@id=\"ftFcPrice\"])[2]")
    WebElement fullPriceTesterPlusSmartTools;

    @FindBy(xpath = "(//div[@id=\"testerPartFcPrice\"])[2]")
    WebElement nowPriceTesterSmartToolsBlock;


    public OrderPage clickGotItButton() {
        gotItButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage moveToPricesTable() {
        Actions action = new Actions(BrowserManager.getBrowser());
        action.moveToElement(priceTable).build().perform();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage selectTwoLicenses() {
        Select numberOfLicenses = new Select(numberOfLicensesSelection);
        numberOfLicenses.selectByIndex(1);
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseStandardMonthlySubscription() {
        standardRadioButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseStandardAnnualSubscription() {
        standardRadioButton.click();
        annualStandardSubscriptionInMonth.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseStandardLifetimeSubscription() {
        standardRadioButton.click();
        lifeStandardSubscription.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseVIPMonthlySubscription() {
        vipRadioButton.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseVIPAnnualSubscription() {
        vipRadioButton.click();
        annualVipSubscriptionInMonth.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    public OrderPage chooseVIPLifetimeSubscription() {
        vipRadioButton.click();
        lifeVipSubscription.click();
        return PageFactory.initElements(BrowserManager.getBrowser(), OrderPage.class);
    }

    // rowNumber from excel table
    // each row - one product
    public boolean isProductPricesCorrect(int rowNumber) {

        int columnNumber;
        String expectedPrice;
        String actualPrice;

        // creating utilities for getting needed methods
        Utilities utilities = new Utilities();
        // creating ArrayList for comperison results
        ArrayList<Boolean> comperisonResults = new ArrayList<>();
        // getting data from excel
        XSSFSheet expectedResults = XLSParser.getDataFromExcel();

        // loop for getting and comparing results from columns
        for (columnNumber = 1; columnNumber <= 9; columnNumber++) {
            // getRow() specify which row we want to read
            // and getCell() specify which column to read
            // getRawValue() specify that we are reading String data
            expectedPrice = expectedResults.getRow(rowNumber).getCell(columnNumber).getRawValue();
            // cheking cell
            if (!expectedPrice.equals("0")) {
                // assign exact element from webpage depends on columnNumber
                switch (columnNumber) {
                    case 1:
                        webElement = totalPrice;
                        break;
                    case 2:
                        webElement = nowPriceTester;
                        break;
                    case 3:
                        webElement = nowPriceData;
                        break;
                    case 4:
                        webElement = totalSave;
                        break;
                    case 5:
                        webElement = fullPriceTester;
                        break;
                    case 6:
                        webElement = savePriceTester;
                        break;
                    case 7:
                        webElement = savePriceData;
                        break;
                    case 8:
                        if (rowNumber == 3 || rowNumber == 9) {
                            webElement = monthlyStandardSubscriptionInMonth;
                        } else if (rowNumber == 4 || rowNumber == 10) {
                            webElement = annualStandardSubscriptionInMonth;
                        } else if (rowNumber == 6 || rowNumber == 12) {
                            webElement = monthlyVipSubscriptionInMonth;
                        } else if (rowNumber == 7 || rowNumber == 13) {
                            webElement = annualVipSubscriptionInMonth;
                        }
                        break;
                    case 9:
                        webElement = fullPriceWithoutDiscount;
                        break;
                    default:
                        webElement = null;
                        break;
                }
                // getting clean number from webElement
                actualPrice = utilities.getNeededNumberFromWebElement(webElement);
                // adding comparison results to ArrayList
                comperisonResults.add(expectedPrice.equals(actualPrice));
            }
        }
        // print ArrayList with results on the screen
        System.out.println(comperisonResults);
        // return true if all elements in ArrayList true
        return !comperisonResults.contains(Boolean.FALSE);
    }

    // one more variant for comparison
    // use for 15 row, special offers block on webpage
    public boolean isForexTesterPlusCopierPricesCorrect() {

        XSSFSheet expectedPrices = XLSParser.getDataFromExcel();

        Utilities utilities = new Utilities();

        String actualTotalPriceTesterPlusCopier = utilities.getNeededNumberFromWebElement(fullPriceTesterPlusCopier);
        String expectedTotalPriceTesterPlusCopier = expectedPrices.getRow(15).getCell(1).getRawValue();

        String actualNowPriceTesterCopierBlock = utilities.getNeededNumberFromWebElement(nowPriceTesterCopierBlock);
        String expectedNowPriceTesterCopierBlock = expectedPrices.getRow(15).getCell(2).getRawValue();

        String actualFullPriceTesterCopierBlock = utilities.getNeededNumberFromWebElement(fullPriceTesterCopierBlock);
        String expectedFullPriceTesterCopierBlock = expectedPrices.getRow(15).getCell(5).getRawValue();

        String actualFullPriceWithoutDiscountTesterPlusCopier = utilities.getNeededNumberFromWebElement(fullPriceWithoutDiscountTesterPlusCopier);
        String expectedFullPriceWithoutDiscountTesterPlusCopier = expectedPrices.getRow(15).getCell(9).getRawValue();

        System.out.print(expectedTotalPriceTesterPlusCopier.equals(actualTotalPriceTesterPlusCopier) + ", ");
        System.out.print(expectedNowPriceTesterCopierBlock.equals(actualNowPriceTesterCopierBlock) + ", ");
        System.out.print(expectedFullPriceTesterCopierBlock.equals(actualFullPriceTesterCopierBlock) + ", ");
        System.out.print(expectedFullPriceWithoutDiscountTesterPlusCopier.equals(actualFullPriceWithoutDiscountTesterPlusCopier));

        return expectedTotalPriceTesterPlusCopier.equals(actualTotalPriceTesterPlusCopier)
                && expectedNowPriceTesterCopierBlock.equals(actualNowPriceTesterCopierBlock)
                && expectedFullPriceTesterCopierBlock.equals(actualFullPriceTesterCopierBlock)
                && expectedFullPriceWithoutDiscountTesterPlusCopier.equals(actualFullPriceWithoutDiscountTesterPlusCopier);
    }

    // use for 16 row, special offers block on webpage
    public boolean isForexTesterPlusSmartToolsPricesCorrect() {

        XSSFSheet expectedPrices = XLSParser.getDataFromExcel();

        Utilities utilities = new Utilities();

        String actualTotalPriceTesterPlusSmartTools = utilities.getNeededNumberFromWebElement(fullPriceTesterPlusSmartTools);
        String expectedTotalPriceTesterPlusSmartTools = expectedPrices.getRow(16).getCell(1).getRawValue();

        String actualNowPriceTesterSmartToolsBlock = utilities.getNeededNumberFromWebElement(nowPriceTesterSmartToolsBlock);
        String expectedNowPriceTesterSmartToolsBlock = expectedPrices.getRow(16).getCell(2).getRawValue();

        String actualFullPriceTesterSmartToolsBlock = utilities.getNeededNumberFromWebElement(fullPriceTesterSmartToolsBlock);
        String expectedFullPriceTesterSmartToolsBlock = expectedPrices.getRow(16).getCell(5).getRawValue();

        String actualFullPriceWithoutDiscountTesterPlusSmartTools = utilities.getNeededNumberFromWebElement(fullPriceWithoutDiscountTesterPlusSmartTools);
        String expectedFullPriceWithoutDiscountTesterPlusSmartTools = expectedPrices.getRow(16).getCell(9).getRawValue();

        System.out.print(expectedTotalPriceTesterPlusSmartTools.equals(actualTotalPriceTesterPlusSmartTools) + ", ");
        System.out.print(expectedNowPriceTesterSmartToolsBlock.equals(actualNowPriceTesterSmartToolsBlock) + ", ");
        System.out.print(expectedFullPriceTesterSmartToolsBlock.equals(actualFullPriceTesterSmartToolsBlock) + ", ");
        System.out.print(expectedFullPriceWithoutDiscountTesterPlusSmartTools.equals(actualFullPriceWithoutDiscountTesterPlusSmartTools));

        return expectedTotalPriceTesterPlusSmartTools.equals(actualTotalPriceTesterPlusSmartTools)
                && expectedNowPriceTesterSmartToolsBlock.equals(actualNowPriceTesterSmartToolsBlock)
                && expectedFullPriceTesterSmartToolsBlock.equals(actualFullPriceTesterSmartToolsBlock)
                && expectedFullPriceWithoutDiscountTesterPlusSmartTools.equals(actualFullPriceWithoutDiscountTesterPlusSmartTools);
    }

}
