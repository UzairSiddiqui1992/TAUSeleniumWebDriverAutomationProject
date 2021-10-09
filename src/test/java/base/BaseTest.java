package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;


public class BaseTest {
    private WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp()
    {
        browserInitialize("Firefox");
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Title : "+driver.getTitle());
        homePage=new HomePage(driver);

    }
    @AfterMethod
    public void tearDown()
    {
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

}
