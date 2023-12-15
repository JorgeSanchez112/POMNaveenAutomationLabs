package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(css = "#top-header-menu > b")
    private WebElement companyName;
    @FindBy(css = "#main-nav > div:nth-child(3) > a")
    private WebElement contactItem;
    @FindBy(css = "#main-nav > div:nth-child(5) > a")
    private WebElement dealItem;
    @FindBy(css = "#main-nav > div:nth-child(6) > a")
    private WebElement taskItem;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public Boolean isContactsLinkVisible(){
        util.TestUtil.elementWait(driver,contactItem);
        return contactItem.isDisplayed();
    }

    public Boolean isDealsLinkVisible(){
        util.TestUtil.elementWait(driver,dealItem);
        return dealItem.isDisplayed();
    }

    public Boolean isTasksLinkVisible(){
        util.TestUtil.elementWait(driver,taskItem);
        return taskItem.isDisplayed();
    }

    public ContactsPage clickOnContactItem(){

        util.TestUtil.elementWait(driver,contactItem);
        contactItem.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealItem(){
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
