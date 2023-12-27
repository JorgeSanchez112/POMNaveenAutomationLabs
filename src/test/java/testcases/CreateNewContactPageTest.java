package test.java.testcases;

import main.java.base.TestBase;
import main.java.pages.*;
import main.java.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateNewContactPageTest extends TestBase {

    IndexPage indexPage;
    LoginPage loginPage;
    HomePage homePage;
    ContactsPage contactsPage;
    CreateNewContactPage createNewContactPage;

    String sheetName = "contacts";

    public CreateNewContactPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnLogInButton();
        loginPage.typeOnLogin(prop.getProperty("email"), prop.getProperty("password"));
        homePage = loginPage.clickOnLoginButton();
        contactsPage = homePage.clickOnContactItem();
        createNewContactPage = contactsPage.clickOnCreateButton();
    }

    @Test
    public void isTitlePageCorrect(){
        Assert.assertEquals(createNewContactPage.getPageTitleText(),"Create New Contact");
    }

    @DataProvider
    public Object[][] getCRMTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(dataProvider = "getCRMTestData")
    public void validateCreateNewContact(String firstname, String lastName, String company, String category){
        createNewContactPage.createNewContact(firstname,lastName,company, category);
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }
}
