package package1;

//import org.apache.log4j.PropertyConfigurator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;




public class BrowserHelper {

  public WebDriver driver = new FirefoxDriver();
  String pagetitle = "Twitter";
  public String baseurl = "http://twitter.com/";
  
  
  //static Logger log = Logger.getLogger(BrowserHelper.class);
  //Logger log = java.util.logging.Logger.getLogger(driver.class.getName());

  
  @BeforeTest
  public void setup() {
	  
	  driver.get(baseurl);
	  String title = driver.getTitle();
	  Assert.assertEquals(pagetitle, title);
	  driver.findElement(By.xpath("//input[@id='signin-email']")).sendKeys("gopi.ror@live.com");
	  driver.findElement(By.xpath("//input[@id='signin-password']")).sendKeys("(kodanda&rama");
	  driver.findElement(By.xpath("//button[contains(@class, 'submit btn primary-btn')]")).click();
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	  
  }

  @AfterTest
  public void teardown() {
	  driver.quit();
  }

}