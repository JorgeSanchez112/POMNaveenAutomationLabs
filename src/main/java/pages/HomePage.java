package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

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

    public Boolean isContactsLinkVisible(){
        return contactItem.isDisplayed();
    }

    public Boolean isDealsLinkVisible(){
        return dealItem.isDisplayed();
    }

    public Boolean isTasksLinkVisible(){
        return taskItem.isDisplayed();
    }

    public ContactsPage clickOnContactItem(){
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(contactItem));*/
        util.TestUtil.elementWait(driver,contactItem);
        contactItem.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealItem(){
       /* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(dealItem));*/
        util.TestUtil.elementWait(driver,dealItem);
        dealItem.click();
        return new DealsPage();
    }

    public TasksPage clickOnTaskItem(){
        util.TestUtil.elementWait(driver,taskItem);
        taskItem.click();
        return new TasksPage();
    }

}
