package test.java.testcases;

import main.java.base.TestBase;
import main.java.pages.IndexPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
