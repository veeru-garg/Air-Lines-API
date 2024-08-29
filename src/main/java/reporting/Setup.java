package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Setup implements ITestListener {

    private static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        String fileName = ExtentReportManager.getReportNameWithTimeStamp();
        String fileFullPath = "/Users/ris-macmini/Downloads/RestAssuredAutomation/reports";
        extentReports=   ExtentReportManager.createInstance(fileFullPath,"Test API Automation Report","Test ExecutionReport");

    }

    public void onFinish(ITestContext context) {
        if (extentReports != null){
            extentReports.flush();
        }

        try {
            String pathOfReport = System.getProperty("user.dir")+"//reports//index.html";
            File extentReport = new File(pathOfReport);
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestFailure(ITestResult result){

        ExtentReportManager.logFailureDetails(result.getThrowable().getMessage());
        String stackTrace = Arrays.toString(result.getThrowable().getStackTrace());
        stackTrace = stackTrace.replace(",","<br>");
        String formatedTrace = "<details>\n" +
                "  <summary>Click here to see the Exception logs</summary>\n" +
                "  "+stackTrace+"\n" +
                "</details>\n";
        ExtentReportManager.logExceptionDetails(formatedTrace);

    }

    public void onTestStart(ITestResult result) {
        ExtentTest test = extentReports.createTest("Test name " + result.getTestClass().getName() + " - " + result.getMethod().getMethodName());
        extentTest.set(test);
    }

}
