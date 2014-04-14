package package1;

//import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

//import org.testng.annotations.BeforeTest;




public class BrowserHelper {

  //WebDriver driver = new FirefoxDriver();
  String pagetitle = "Twitter";
  public String baseurl = "http://twitter.com/";
  
  private static WebDriver driver = null;
  protected static DesiredCapabilities dCaps;
  
  public WebDriver getDriver() {
	  
          return driver;
  }
  @Parameters("browser")
  @BeforeMethod
  public void setup(String browser) {
	  if (browser.equalsIgnoreCase("chrome")) {
	  System.setProperty("webdriver.chrome.driver","/home/sarma/Downloads/chromedriver"); 		  
	  driver = new ChromeDriver();
	  } else if (browser.equalsIgnoreCase("safari")){
		  driver = new SafariDriver();  
	  } else if (browser.equalsIgnoreCase("ie")) {
		  driver = new InternetExplorerDriver();
	  } else if (browser.equalsIgnoreCase("phantomjs")) {
		  dCaps = new DesiredCapabilities();
		  dCaps.setJavascriptEnabled(true);
		  dCaps.setCapability("takesScreenshot", false);
		  
		  driver = new PhantomJSDriver(dCaps);	
		  
	  } else { driver = new FirefoxDriver();  }
	  
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  Assert.assertEquals(pagetitle, title);
	  driver.findElement(By.xpath("//input[@id='signin-email']")).sendKeys("gopi.ror@live.com");
	  driver.findElement(By.xpath("//input[@id='signin-password']")).sendKeys("(kodanda&rama");
	  driver.findElement(By.xpath("//button[contains(@class, 'submit btn primary-btn')]")).click();
  }

  @AfterMethod
  public void teardown() {
	  if (driver != null)
      {
              try
              {
	  driver.quit();
              }
              catch (WebDriverException e) {
                  System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                  System.out.println(e);
              }

      }
  }

}
