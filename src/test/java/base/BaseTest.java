package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class BaseTest {
    private WebDriver driver;

    public void setUp()
    {
        browserInitialize("Firefox");
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println("Title : "+driver.getTitle());
        driver.manage().window().maximize();
        WebElement shiftingContent=driver.findElement(By.linkText("Shifting Content"));
        shiftingContent.click();
        WebElement menuElement=driver.findElement(By.linkText("Example 1: Menu Element"));
        menuElement.click();
        //List<WebElement> listElement=driver.findElements(By.cssSelector("ul li"));
        List<WebElement>listElement=driver.findElements(By.tagName("li"));
        System.out.println("Menu Element count : "+listElement.size());
        for(WebElement listElem:listElement)
            System.out.println(listElem.getText());


       // WebElement inputLink=driver.findElement(By.linkText("Inputs"));
        //inputLink.click();
        driver.quit();

    }
    public void browserInitialize(String browser)
    {
        if(browser=="Chrome")
        {
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            driver=new ChromeDriver();
        }
        else if(browser=="Firefox")
        {
            System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
            driver=new FirefoxDriver();
        }
        else if (browser=="Edge")
        {
            System.setProperty("webdriver.edge.driver","resources/msedgedriver.exe");
            driver=new EdgeDriver();
        }

    }

    public static void main(String[] args) {
        BaseTest baseTest=new BaseTest();
        baseTest.setUp();
    }

}
