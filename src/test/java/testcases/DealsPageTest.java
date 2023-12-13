package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DealsPage;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class DealsPageTest extends TestBase {
    DealsPage dealsPage;
    HomePage homePage;
    LoginPage loginPage;
    IndexPage indexPage;

    public DealsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        dealsPage = new DealsPage();
        indexPage.clickOnLogInButton();
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        loginPage.clickOnLoginButton();
        dealsPage = homePage.clickOnDealItem();
    }


    @Test
    public void isTitlePageCorrect(){
        Assert.assertEquals(dealsPage.getPageTitleText(),"Deals");
    }

    @Test
    public void validatePipelineButtonIsVisible(){
        Assert.assertTrue(dealsPage.isPipelineButtonVisible());
    }

    @Test
    public void validateShowFilterButtonIsVisible(){
        Assert.assertTrue(dealsPage.isShowFiltersButtonVisible());
    }

    @Test
    public void validateBoardButtonIsVisible(){
        Assert.assertTrue(dealsPage.isBoardButtonVisible());
    }

    @Test
    public void validateManageTargetsButtonIsVisible(){
        Assert.assertTrue(dealsPage.isManageTargetsButtonVisible());
    }

    @Test
    public void validateExportButtonIsVisible(){
        Assert.assertTrue(dealsPage.isExportButtonVisible());
    }

    @Test
    public void validateCreateButtonIsVisible(){
        Assert.assertTrue(dealsPage.isCreateButtonVisible());
    }

    @Test
    public void isTableTitleTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleColumnText(),"Title");
    }

    @Test
    public void isTableCompanyTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleCompanyText(),"Company");
    }

    @Test
    public void isTableCloseDateTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleCloseDateText(),"Close Date");
    }

    @Test
    public void isTableAmountTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleAmountText(),"Amount");
    }

    @Test
    public void isTableStatusTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleStatusText(),"Status");
    }

    @Test
    public void isTableStageTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleStageText(),"Stage");
    }
    @Test
    public void isTableOptionsTitleCorrect(){
        Assert.assertEquals(dealsPage.getTitleOptionsText(),"Options");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }

}
