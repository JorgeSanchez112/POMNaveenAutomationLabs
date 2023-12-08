package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(className = "submit")
    WebElement loginButton;
    @FindBy(css = "#container > div")
    WebElement accessWithGoogle;
    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPasswordLink;
    @FindBy(linkText = "Sign Up")
    WebElement signUpLink;

    public LoginPage(){
        PageFactory.initElements(driver, this);
    }

    public String  validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateAccessWithGoogle(){
        return accessWithGoogle.isDisplayed();
    }

    public boolean validateForgotPassword(){
        return forgotPasswordLink.isDisplayed();
    }

    public void typeOnLogin(String email, String password){
        if (email != null && password != null) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(prop.getProperty("user"));
        } else {
            System.out.println("Username or password is null.");
        }
    }

    public HomePage clickOnLogin(){
        loginButton.click();
        return new HomePage();
    }
}
