package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactsPage;
import pages.HomePage;
import pages.IndexPage;
import pages.LoginPage;

public class ContactsPageTest extends TestBase {
    ContactsPage contactsPage;
    HomePage homePage;
    LoginPage loginPage;
    IndexPage indexPage;

    public ContactsPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        indexPage = new IndexPage();
        loginPage = new LoginPage();
        homePage = new HomePage();
        contactsPage = new ContactsPage();
        indexPage.clickOnLogInButton();
        loginPage.typeOnLogin(prop.getProperty("email"),prop.getProperty("password"));
        loginPage.clickOnLoginButton();
        homePage.clickOnContactItem();

    }

    @Test
    public void isTitlePageCorrect(){
        Assert.assertEquals(contactsPage.getTitlePageText(),"Contacts");
    }

    @Test
    public void validateShowFilterButtonIsVisible(){
        Assert.assertTrue(contactsPage.isShowFiltersButtonVisible());
    }

    @Test
    public void validateExportButtonIsVisible(){
        Assert.assertTrue(contactsPage.isExportButtonVisible());
    }

    @Test
    public void validateCreateButtonIsVisible(){
        Assert.assertTrue(contactsPage.isCreateButtonVisible());
    }

    @Test
    public void isTableNameTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleNameText(),"Name");
    }

    @Test
    public void isTableAddressTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleAddressText(),"Address");
    }

    @Test
    public void isTableCategoryTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleCategoryText(),"Category");
    }

    @Test
    public void isTableStatusTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleStatusText(),"Status");
    }

    @Test
    public void isTablePhoneTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitlePhoneText(),"Phone");
    }

    @Test
    public void isTableEmailTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleEmailText(),"Email");
    }

    @Test
    public void isTableOptionsTitleCorrect(){
        Assert.assertEquals(contactsPage.getTitleOptionsText(),"Options");
    }

    @AfterMethod
    public void quit(){
        driver.quit();
    }


}
