package dropdown;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropDownPage;

import java.util.List;

public class DropdownTest extends BaseTest {

    @Test
    public void testSelectOptions() {
        DropDownPage dropdownPage = homePage.clicksOnDropdown();
        String dropdownOption = "Option 1";
        dropdownPage.selectFromDropdown(dropdownOption);
        List<String> selectedOpt = dropdownPage.getSelectedOptions();
        System.out.println(selectedOpt + " ");
        Assert.assertEquals(selectedOpt.size(), 1, "Incorrect number of selection!");
        Assert.assertTrue(selectedOpt.contains(dropdownOption),"Option not selected");


    }
}
