package test.java.testcases;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import main.java.base.TestBase;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    IndexPage indexPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnLogInButton();
    }

    @Test(description = "Verify correct page title")
    @Severity(SeverityLevel.MINOR)
    public void loginPageTitleTest(){
        Assert.assertEquals(loginPage.validateLoginPageTitle(),"Cogmento CRM");
    }

    @Test(description = "Verify google login method visible")
    @Severity(SeverityLevel.NORMAL)
    public void isAccessWithGoogleVisible(){
        Assert.assertTrue(loginPage.validateAccessWithGoogle());
    }

    @Test(description = "Verify password recover method is visible")
    @Severity(SeverityLevel.NORMAL)
    public void isForgotPasswordVisible(){
        Assert.assertTrue(loginPage.validateForgotPassword());
    }

    @Test(description = "Verify login success")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        loginPage.clickOnLoginButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
