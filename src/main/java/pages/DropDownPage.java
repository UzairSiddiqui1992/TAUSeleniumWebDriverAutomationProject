package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    /*

    Select the option from the dropdown

     */

    public void selectFromDropdown(String options) {
        Select selectDropdown = new Select(driver.findElement(dropdown));
        selectDropdown.selectByVisibleText(options);


    }

    /*
            Method that gets the Selected options so that we can assert our test
     */
    public List<String> getSelectedOptions() {
        Select getSelected = new Select(driver.findElement(dropdown));
        List<WebElement> selectedElements = getSelected.getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }
}
