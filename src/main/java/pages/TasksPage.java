package pages;

import base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {
    public TasksPage(){
        PageFactory.initElements(driver,this);
    }
}
