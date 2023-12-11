package testcases;

import base.TestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.IndexPage;

public class IndexPageTest extends TestBase {
    IndexPage indexPage;

    public IndexPageTest(){
        super();
    }

    @BeforeMethod
    public void SetUp(){
        initialization();
        indexPage = new IndexPage();
    }

    @Test
    public void clickLogInButton(){
        indexPage.clickOnLogInButton();
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
