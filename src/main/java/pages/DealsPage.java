package main.java.pages;

import main.java.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DealsPage extends TestBase {
    @FindBy(css = ".ui > span")
    WebElement pageTitle;
    @FindBy(css = ".page-header >* .item > * ")
    List<WebElement> headerElements;
    @FindBy(css = ".full-width > * > th")
    List<WebElement> tableTitles;

    public DealsPage(){
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText(){
        return pageTitle.getText();
    }

    public String getTitleColumnText(){
        return tableTitles.get(1).getText();
    }

    public String getTitleCompanyText(){
        return tableTitles.get(2).getText();
    }

    public String getTitleCloseDateText(){
        return tableTitles.get(3).getText();
    }

    public String getTitleAmountText(){
        return tableTitles.get(4).getText();
    }

    public String getTitleStatusText(){
        return tableTitles.get(5).getText();
    }

    public String getTitleStageText(){
        return tableTitles.get(6).getText();
    }

    public String getTitleOptionsText(){
        return tableTitles.get(7).getText();
    }

    public Boolean isPipelineButtonVisible(){
        return headerElements.get(0).isDisplayed();
    }

    public Boolean isShowFiltersButtonVisible(){
        return headerElements.get(3).isDisplayed();
    }

    public Boolean isBoardButtonVisible(){
        return headerElements.get(4).isDisplayed();
    }

    public Boolean isManageTargetsButtonVisible(){
        return headerElements.get(5).isDisplayed();
    }

    public Boolean isExportButtonVisible(){
        return headerElements.get(6).isDisplayed();
    }

    public Boolean isCreateButtonVisible(){
        return headerElements.get(7).isDisplayed();
    }


}
