package pages;

import base.TestBase;
import io.qameta.allure.Step;
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

    @Step("getting text of login step")
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    @Step("Verifying google login is displayed step")
    public boolean validateAccessWithGoogle(){
        util.TestUtil.switchToFrameForIndex(0);
        return accessWithGoogle.isDisplayed();
    }

    @Step("Verifying forgot password link is displayed step")
    public boolean validateForgotPassword(){
        return forgotPasswordLink.isDisplayed();
    }

    @Step("Verifying Typing with email: {0} and password: {1} step")
    public void typeOnLogin(String email, String password){
        if (email != null && password != null) {
            emailInput.sendKeys(email);
            passwordInput.sendKeys(password);
        } else {
            System.out.println("Username or password is null.");
        }
    }

    @Step("Verify click On login button step")
    public HomePage clickOnLoginButton(){
        loginButton.click();
        return new HomePage();
    }

}
