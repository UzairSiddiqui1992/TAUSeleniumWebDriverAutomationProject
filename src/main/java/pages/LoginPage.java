package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField= By.id("username");
    private By passwordField=By.id("password");
    private By logInBtn=By.className("radius");
    private By validationError=By.className("error");

    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void setUsername(String username)
    {
        driver.findElement(usernameField).sendKeys(username);
    }
    public void setPassword(String password)
    {
        driver.findElement(passwordField).sendKeys(password);
    }
    public SecureAreaPage clicksOnLogin()
    {
        driver.findElement(logInBtn).click();
        return new SecureAreaPage(driver);
    }
    public String showError()
    {
        return driver.findElement(validationError).getText();
    }
}
