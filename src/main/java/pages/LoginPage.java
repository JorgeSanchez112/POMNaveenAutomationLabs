package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(name = "email")
    private WebElement emailInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(className = "submit")
    private WebElement loginButton;
    @FindBy(id = "container")
    private WebElement accessWithGoogle;
    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPasswordLink;
    @FindBy(linkText = "Sign Up")
    private WebElement signUpLink;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    public String  validateLoginPageTitle(){
        return driver.getTitle();
    }

    public boolean validateAccessWithGoogle(){
        driver.switchTo().frame(0);
        return accessWithGoogle.isDisplayed();
    }

    public boolean validateForgotPassword(){
        return forgotPasswordLink.isDisplayed();
    }

    public void typeOnLogin(String email, String password){
        if (email != null && password != null) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
        } else {
            System.out.println("Username or password is null.");
        }
    }

    public IndexPage clickOnLoginButton(){
        loginButton.click();
        return new IndexPage();
    }

    public SignUpPage clickOnSignUpLink(){
        signUpLink.click();
        return new SignUpPage();
    }
}
