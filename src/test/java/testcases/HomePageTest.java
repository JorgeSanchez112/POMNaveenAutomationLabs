package test.java.testcases;

import main.java.base.TestBase;
import main.java.pages.HomePage;
import main.java.pages.IndexPage;
import main.java.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
