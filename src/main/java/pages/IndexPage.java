package main.java.pages;

import main.java.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends TestBase {
    @FindBy(linkText = "LOG IN")
    private WebElement logInButton;

    public IndexPage(){
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickOnLogInButton(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(logInButton));
        logInButton.click();
        return new LoginPage();
    }


}
