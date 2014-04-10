package package1;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;



public class CustomListener extends TestListenerAdapter{
    private int m_count = 0;
    @Override
    public void onTestFailure(ITestResult tr) {
        Object currentClass = tr.getInstance();
        WebDriver driver = ((BrowserHelper) currentClass).getDriver();
        
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        
        String methodName = tr.getName();  
        String filename = methodName+"_"+ formater.format(calendar.getTime())+".png";
        String destDir = "./reports/screenshots/";
        new File(destDir).mkdirs();
        
        
        
        if(!tr.isSuccess()){
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(scrFile, new File(destDir + "/" + filename));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        Reporter.setEscapeHtml(false);
        //String screenPath = "<a href=../../reports/screenshots/" + filename + ">Screenshot</a>";
        String screenPath = "<a href=../ws/reports/screenshots/" + filename + ">Screenshot</a>";
        Reporter.log(screenPath);  
        
        log(tr.getName()+ "--Test method failed\n");
    }
	 
    @Override
    public void onTestSkipped(ITestResult tr) {
        log(tr.getName()+ "--Test method skipped\n");
    }
	 
    @Override
    public void onTestSuccess(ITestResult tr) {
        log(tr.getName()+ "--Test method success\n");
    }
	 
    private void log(String string) {
        System.out.print(string);
        if (++m_count % 40 == 0) {
	    System.out.println("");
        }
    }


}
