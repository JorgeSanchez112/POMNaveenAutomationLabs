package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(css = "#top-header-menu > b")
    WebElement companyName;
    @FindBy(css = "#main-nav > div:nth-child(3) > a")
    WebElement contactItem;
    @FindBy(css = "#main-nav > div:nth-child(5) > a")
    WebElement dealItem;
    @FindBy(css = "#main-nav > div:nth-child(6) > a")
    WebElement taskItem;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public ContactsPage clickOnContactItem(){
        contactItem.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealItem(){
        dealItem.click();
        return new DealsPage();
    }

    public TasksPage clickOnTaskItem(){
        taskItem.click();
        return new TasksPage();
    }

}
