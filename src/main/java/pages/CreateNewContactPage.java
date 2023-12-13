package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class CreateNewContactPage extends TestBase {
    @FindBy(css = ".ui > .selectable")
    WebElement titlePage;
    @FindBy(className = "linkedin")
    WebElement saveButton;
    @FindBy(name = "first_name")
    WebElement firstNameInput;
    @FindBy(name = "last_name")
    WebElement lastNameInput;
    @FindBy(xpath = "//*[@name='company'] / input")
    WebElement companyInput;
    @FindBy(xpath = "//*[@name='category']")
    List<WebElement> categoriesListBox;


    public CreateNewContactPage(){
        PageFactory.initElements(driver,this);
    }

    public String getPageTitleText(){
        return titlePage.getText();
    }

    public void selectCategory(String value){
        for (WebElement a: categoriesListBox) {
            if (Objects.equals(a.getText(), value)){
                a.click();
            }
        }

    }

    public void createNewContact(String firstName, String lastName, String company, String category){
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        companyInput.sendKeys(company);
        selectCategory("Customer");
        saveButton.click();
    }
}
