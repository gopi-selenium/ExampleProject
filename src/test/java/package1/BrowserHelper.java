package package1;

//import org.apache.log4j.PropertyConfigurator;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
//import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

//import org.testng.annotations.BeforeTest;




public class BrowserHelper {

  WebDriver driver;
  String pagetitle = "Twitter";
  public String baseurl = "http://twitter.com/";

  

  protected static DesiredCapabilities dCaps;
  
  public WebDriver getDriver() {
	 
          return driver;
  }
  @Parameters("browser")
  @BeforeMethod
  public void setup(String browser) throws MalformedURLException {
	  URL hubUrl = new URL("http://50.50.50.183:4444/wd/hub");
	  
	  if (browser.equalsIgnoreCase("chrome")) {
		  //System.setProperty("webdriver.chrome.driver","/home/sarma/Downloads/chromedriver"); 		  
		  //driver = new ChromeDriver();
		  DesiredCapabilities c = DesiredCapabilities.chrome();

		  c.setBrowserName("chrome");
		  c.setPlatform(Platform.LINUX);
		  driver = new RemoteWebDriver(hubUrl, c);
		  
	  } else if (browser.equalsIgnoreCase("IE")){
	      DesiredCapabilities capabilities = new DesiredCapabilities();
	      capabilities.setBrowserName("internet explorer");
	      capabilities.setPlatform(Platform.WINDOWS);

	      driver = new RemoteWebDriver(hubUrl, capabilities);
	  
	  } else if (browser.equalsIgnoreCase("phantomjs")) {
		  dCaps = new DesiredCapabilities();
		  dCaps.setJavascriptEnabled(true);
		  dCaps.setCapability("takesScreenshot", false);
		  System.setProperty("phantomjs.binary.path","/home/sarma/Downloads/phantomjs-1.9.7-linux-x86_64/bin/phantomjs");
		  driver = new PhantomJSDriver(dCaps);
		  
	  } else if (browser.equalsIgnoreCase("firefox")){
	  driver = new FirefoxDriver();}
	  
	  
	  driver.get(baseurl);
	  driver.manage().window().maximize();
	  String title = driver.getTitle();
	  Assert.assertEquals(pagetitle, title);
	  driver.findElement(By.xpath("//input[@id='signin-email']")).sendKeys("gopi.ror@live.com");
	  driver.findElement(By.xpath("//input[@id='signin-password']")).sendKeys("(kodanda&rama");
	  driver.findElement(By.xpath("//button[contains(@class, 'submit btn primary-btn')]")).click();
	  }
	  
  @AfterMethod
  public void teardown() throws InterruptedException {
	  if (driver != null)
      {
              try
              {
      Thread.sleep(5000);      	  
      driver.findElement(By.xpath("//a[@id='user-dropdown-toggle']")).click();
      Thread.sleep(2000);  
      driver.findElement(By.xpath("//li[@id='signout-button']/button[contains(@class,'dropdown-link')]"));
	  driver.quit();
              }
              catch (WebDriverException e) {
                  System.out.println("***** CAUGHT EXCEPTION IN DRIVER TEARDOWN *****");
                  System.out.println(e);
              }

      }
  }

}
