package main.java.pages;

import main.java.base.TestBase;
import main.java.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsPage extends TestBase {
    @FindBy(css = ".ui > .selectable")
    WebElement pageTitle;
    @FindBy(className = "linkedin")
    List<WebElement> buttons;
    @FindBy(css = ".full-width >* th")
    List<WebElement> tableTitles;


    public ContactsPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitlePageText(){
        return pageTitle.getText();
    }

    public String getTitleNameText(){
        return tableTitles.get(1).getText();
    }

    public String getTitleAddressText(){
        return tableTitles.get(2).getText();
    }

    public String getTitleCategoryText(){
        return tableTitles.get(3).getText();
    }

    public String getTitleStatusText(){
        return tableTitles.get(4).getText();
    }

    public String getTitlePhoneText(){
        return tableTitles.get(5).getText();
    }

    public String getTitleEmailText(){
        return tableTitles.get(6).getText();
    }

    public String getTitleOptionsText(){
        return tableTitles.get(7).getText();
    }

    public boolean isShowFiltersButtonVisible(){
        return buttons.get(0).isDisplayed();
    }

    public boolean isExportButtonVisible(){
        return buttons.get(1).isDisplayed();
    }

    public boolean isCreateButtonVisible(){
        return buttons.get(2).isDisplayed();
    }

    public CreateNewContactPage clickOnCreateButton(){
        TestUtil.elementWait(driver,buttons.get(2));
        buttons.get(2).click();
        return new CreateNewContactPage();
    }

}
