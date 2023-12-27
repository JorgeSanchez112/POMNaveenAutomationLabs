package main.java.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;
    final private int RETRY_LIMIT = 3;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (counter < RETRY_LIMIT){
            counter++;
            return true;
        }
        return false;
    }
}
