package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;
import pages.TasksPage;

public class TasksPageTest extends TestBase {
    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    TasksPage tasksPage;

    public TasksPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnLogInButton();
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        homePage = loginPage.clickOnLoginButton();
        tasksPage = homePage.clickOnTaskItem();
    }

    @Test
    public void isPageTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleText(),"Tasks");
    }

    @Test
    public void isShowFilterButtonVisible(){
        Assert.assertTrue(tasksPage.isShowFiltersButtonVisible());
    }

    @Test
    public void isBoardButtonVisible(){
        Assert.assertTrue(tasksPage.isBoardButtonVisible());
    }

    @Test
    public void isExportButtonVisible(){
        Assert.assertTrue(tasksPage.isExportButtonVisible());
    }

    @Test
    public void isCreateButtonVisible(){
        Assert.assertTrue(tasksPage.isCreateButtonVisible());
    }

    @Test
    public void isTableTitleTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleColumnText(),"Title");
    }

    @Test
    public void isTableTypeTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleTypeText(),"Type");
    }

    @Test
    public void isTableStatusTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleStatusText(),"Status");
    }

    @Test
    public void isTableDueDateTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleDueDateText(),"Due Date");
    }

    @Test
    public void isTableCloseDateTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleCloseDateText(),"Close Date");
    }

    @Test
    public void isTableOptionsTitleCorrect(){
        Assert.assertEquals(tasksPage.getTitleOptionsText(),"Options");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
