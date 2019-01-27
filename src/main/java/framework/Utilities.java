package framework;

import org.openqa.selenium.WebElement;

public class Utilities {

    public String getNeededNumberFromWebElement(WebElement webElement) {
        // getting text from webelement and split it by $
        String[] webElementString = webElement.getText().split("\\$");
        // return the last element from webElementString
        // it will be number in our case
        return webElementString[webElementString.length - 1];
    }
}
