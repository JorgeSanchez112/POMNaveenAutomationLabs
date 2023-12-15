package util;

import base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebEventListener extends TestBase implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Accepting alert");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("Alert accepted");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("Alert Dismissed");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Dismissing alert");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigation to: " + url + "");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to: " + url + "");
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page. " + driver.toString());
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Come back to previous page. " + driver.toString());
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated back to previous page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Refreshing navigate");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("Navigate refreshed");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find element by: " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found element by: " + by.toString());
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("clicked on: " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the: " + element.toString() + " before any changes made");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Element value changed to: " + element.toString());
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switching To: " + windowName + "window");
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        System.out.println("Switched to: " + windowName);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("Exception occurred: " + throwable);
        /*try{
            util.TestUtil.takeScreenShotAtEndOfTest();
        } catch (IOException e){
            e.printStackTrace();
        }*/
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }


    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        System.out.println("Getting Text of element: " + element.toString());
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        System.out.println("Text got of element: " + element.toString());
    }
}
