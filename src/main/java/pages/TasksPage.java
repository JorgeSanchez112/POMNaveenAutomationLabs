package main.java.pages;

import main.java.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TasksPage extends TestBase {
    @FindBy(css = ".ui > .selectable")
    WebElement pageTitle;
    @FindBy(css = ".toolbar-container > .item > *")
    List<WebElement> headerElements;
    @FindBy(css = ".full-width >* > th")
    List<WebElement> tableTitles;

    public TasksPage(){
        PageFactory.initElements(driver,this);
    }

    public String getTitleText(){
        return pageTitle.getText();
    }

    public String getTitleColumnText(){
        return tableTitles.get(1).getText();
    }

    public String getTitleTypeText(){
        return tableTitles.get(2).getText();
    }

    public String getTitleStatusText(){
        return tableTitles.get(3).getText();
    }

    public String getTitleDueDateText(){
        return tableTitles.get(4).getText();
    }

    public String getTitleCloseDateText(){
        return tableTitles.get(5).getText();
    }

    public String getTitleOptionsText(){
        return tableTitles.get(6).getText();
    }

    public boolean isShowFiltersButtonVisible(){
        return headerElements.get(1).isDisplayed();
    }

    public boolean isBoardButtonVisible(){
        return headerElements.get(2).isDisplayed();
    }

    public boolean isExportButtonVisible(){
        return headerElements.get(3).isDisplayed();
    }

    public boolean isCreateButtonVisible(){
        return headerElements.get(4).isDisplayed();
    }

}
