package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.LoginPage;

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

    @Test
    public void loginPageTitleTest(){
        Assert.assertEquals(loginPage.validateLoginPageTitle(),"Cogmento CRM");
    }

    @Test
    public void isAccessWithGoogleVisible(){
        Assert.assertTrue(loginPage.validateAccessWithGoogle());
    }

    @Test
    public void isForgotPasswordVisible(){
        Assert.assertTrue(loginPage.validateForgotPassword());
    }

    @Test
    public void loginTest(){
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        loginPage.clickOnLoginButton();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
