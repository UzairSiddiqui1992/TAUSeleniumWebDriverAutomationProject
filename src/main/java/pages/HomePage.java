package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clicksOnFormAuthentication() {
        clickLink("Form Authentication");
        return new LoginPage(driver);

    }

    public DropDownPage clicksOnDropdown() {
        clickLink("Dropdown");
        return new DropDownPage(driver);

    }

    private void clickLink(String links) {
        driver.findElement(By.linkText(links)).click();
    }
}
