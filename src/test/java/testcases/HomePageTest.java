package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;

    HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnLogInButton();
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        homePage = loginPage.clickOnLoginButton();
    }

    @Test
    public void isContactsLinkVisible(){
        Assert.assertTrue(homePage.isContactsLinkVisible());
    }

    @Test
    public void isDealsLinkVisible(){
        Assert.assertTrue(homePage.isDealsLinkVisible());
    }

    @Test
    public void isTasksLinkVisible(){
        Assert.assertTrue(homePage.isTasksLinkVisible());
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
